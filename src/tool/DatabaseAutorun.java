package tool;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseAutorun implements database<startup>{
    private static Connection con = null;
    public static DatabaseAutorun connect(){
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:storage.db");
            
            var sqltbl = "create table if not exists startup(\n" +
                      "	id integer primary key not null,\n" +
                      "	fullname text not null,\n" +
                      "	status text not null\n" +
                      ");";
            con.prepareStatement(sqltbl).execute();
        }catch(SQLException ex){
            Logger.getLogger(DatabaseBackup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseAutorun.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new DatabaseAutorun();
    }
    
    public boolean close(){
        try{
            if(con != null){
                con.close();
                if(!con.isClosed()){
                    close();
                }else{
                    return con.isClosed();
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(DatabaseBackup.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void insert(startup data)throws SQLException{
        var sql = "insert into startup (id,fullname,status) values(?,?,?);";
        var stm = con.prepareStatement(sql);
        
        stm.setInt(1, data.id);
        stm.setString(2, data.fullname);
        stm.setString(3,data.status);
        
        stm.executeUpdate();
    }
    
    public void update(startup data)throws SQLException{
        var sql = "update startup set fullname=?,status=? where id=?;";
        var stm = con.prepareStatement(sql);
        
        stm.setInt(3, data.id);
        stm.setString(1, data.fullname);
        stm.setString(2, data.status);
        
        stm.executeUpdate();
    }
    
    
    public Queue getAllData(){
        Queue<startup> dataQueue = new LinkedList<>();
        try{
            var sql = "select id,fullname,status from startup;";
            var stm = con.prepareStatement(sql);
            var res = stm.executeQuery();
            
            
            while(res.next()){
                var data = new startup();
                
                data.id = res.getInt("id");
                data.fullname = res.getString("fullname");
                data.status = res.getString("status");
                
                
                dataQueue.add(data);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(DatabaseBackup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataQueue;
    }
    
    public void delete(int id){
        try{
            var sql = "delete from startup where id = ?";
            var stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            
            stm.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(DatabaseBackup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class startup{
    int id;
    String fullname;
    String status;
}
