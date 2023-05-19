package tool;
import java.sql.*;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseBackup implements database<backup> {
    private static Connection con = null;
    
    private DatabaseBackup(){}
    
    public static DatabaseBackup connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:storage.db");
            //if no error, this line is DatabaseBackup connected
            var sqltbl = "create table if not exists backup(\n" +
                      " id integer primary key not null,\n" +
                      " origName text not null,\n" +
                      " identName text not null,\n" +
                      " size int\n" +
                      ");";
            con.prepareStatement(sqltbl).execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBackup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(DatabaseBackup.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new DatabaseBackup();
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
    
    public void insert(backup data) throws SQLException{
        var sql = "insert into backup (id,origName,identName,size) values(?,?,?,?);";
        var stm = con.prepareStatement(sql);
          
        stm.setInt(1, data.id);
        stm.setString(2, data.origName);
        stm.setString(3, data.identName);
        stm.setInt(4, data.size);
            
        stm.executeUpdate();
    }
    
    public void update(backup data)throws SQLException{
        var sql = "update backup set origName=?,identName=?,size=? where id=?;";
        var stm = con.prepareStatement(sql);
        
        stm.setInt(4, data.id);
        stm.setString(1, data.origName);
        stm.setString(2, data.identName);
        stm.setInt(3, data.size);
        
        stm.executeUpdate();
    }
    
    public Queue getAllData(){
        Queue<backup> dataQueue = new LinkedList<>();
        try{
            var sql = "select id,origName,identName,size from backup;";
            var stm = con.prepareStatement(sql);
            var res = stm.executeQuery();
            
            
            while(res.next()){
                var data = new backup();
                
                data.id = res.getInt("id");
                data.origName = res.getString("origName");
                data.identName = res.getString("identName");
                data.size = res.getInt("size");
                
                
                dataQueue.add(data);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(DatabaseBackup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataQueue;
    }
    
    public void delete(int id){
        try{
            var sql = "delete from backup where id = ?";
            var stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            
            stm.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(DatabaseBackup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class backup{
    int id;
    String origName;
    String identName;
    int size;
}