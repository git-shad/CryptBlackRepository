package tool;

import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class autorunPanel extends javax.swing.JPanel {
    private home nt;
    private static DefaultTableModel tbl;
    
    public autorunPanel(home nt) {
        initComponents();
        this.tbl = (DefaultTableModel) table.getModel();
        this.nt = nt;
        feedback.setVisible(false);
        
    }
    
    protected void intoTerminal(String display){
        nt.outText+= display;
        nt.terminal.setText(nt.outText);
    }
    protected void intoFeedback(String display){
        feedback.setVisible(true);
        feedback.setText(display);
    }
    
    public static void autorun(String filename,home nt){
        try{
            database data = DatabaseAutorun.connect();
            var autorunVar = new startup();
            var rand = new Random();
            var file = new File(filename);
       
            //preper 
            autorunVar.id = (100+rand.nextInt(900));
            autorunVar.fullname = file.getAbsolutePath();
            autorunVar.status = "enable";//first insert is enable
            //end
            
            try{
                data.insert(autorunVar);
                Thread.sleep(50);
                data.update(autorunVar);//need update to make sure the data is there
            }catch(java.sql.SQLException ex){
                autorun(filename,nt);
            } catch (InterruptedException ex) {
                Logger.getLogger(autorunPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            var queue = data.getAllData();
       
            /**
              * checkpoint: test if file data is inserted in database if yes the method stop
              */
            var thread = Need.progressAni(nt, 100);
            nt.intoTerminal("\n[autorun] checking if already set ");
            var isExists = false;
            for(int i = 0; i < queue.size();++i){
                var startup = (startup)queue.toArray()[i];
                if(startup.fullname == autorunVar.fullname){
                    thread.stop();
                    data.delete(autorunVar.id);
                    nt.intoTerminal("\n[autorun] its already set");
                    return;
                }
            }
            thread.stop();
            //end
            intoReg(file,reg.insert);
       }catch(Exception ex){
           Logger.getLogger(autorunPanel.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public static void displayData(){
        tbl.setRowCount(0);
        database data = DatabaseAutorun.connect();
        var queue = data.getAllData();
        
        for(var i0 = 0;!queue.isEmpty();++i0){
            var db = (startup)queue.poll();
            
            Object obj[] = {db.id,
                            (new File(db.fullname).getName()),
                            db.status};
            
            for(int i1 = 0; i1 < obj.length; ++i1){
                valueAt(obj[i1],i0,i1);
            }
        }
        
    }
    
    //
    public static void intoReg(File file,reg mode){
        var regPath = "HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run";
        
        if(mode == reg.insert){
            var command = String.format("%s /v \"%s\" /t REG_SZ /d \"%s\"",regPath,file.getName().replace(' ', '_'),file.getAbsolutePath());
            Need.cmd(String.format("reg add %s",command));
        }else if(mode == reg.delete){
            var command = String.format("%s /v %s /f", regPath,file.getName().replace(' ', '_'));
            Need.cmd(String.format("reg delete %s",command));
        }
    }
    
    /**
     * @see valueAt
     * when you set a new row but it's out of Bound
     * it can add a 1 int to make sure no error, 
     * to make sure safe add.
     */
    private static void valueAt(Object obj,int row,int column){
        try{
            tbl.setValueAt(obj, row, column);
        }catch(java.lang.NullPointerException | java.lang.ArrayIndexOutOfBoundsException ex){
            tbl.setRowCount(tbl.getRowCount()+1);
            tbl.setValueAt(obj, row, column);
        }
    }//end
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home = new javax.swing.JLabel();
        backups = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        insertID = new javax.swing.JTextField();
        delete = new javax.swing.JCheckBox();
        enable = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        disable = new javax.swing.JCheckBox();
        feedback = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 51)));
        setMaximumSize(new java.awt.Dimension(522, 372));
        setMinimumSize(new java.awt.Dimension(522, 372));
        setPreferredSize(new java.awt.Dimension(522, 372));

        home.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        home.setText("Home");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        backups.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        backups.setText("Backups");
        backups.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backupsMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel1.setText("Autorun");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        jScrollPane1.setBackground(new java.awt.Color(0, 51, 51));

        table.setBackground(new java.awt.Color(102, 102, 102));
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FILE NAME", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setShowVerticalLines(true);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(150);
            table.getColumnModel().getColumn(2).setMinWidth(90);
            table.getColumnModel().getColumn(2).setPreferredWidth(90);
            table.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        insertID.setActionCommand(null);
        insertID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        insertID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        insertID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertIDActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        delete.setText("Delete");
        delete.setRequestFocusEnabled(false);
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteMousePressed(evt);
            }
        });

        enable.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        enable.setText("Enable");
        enable.setRequestFocusEnabled(false);
        enable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                enableMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel2.setText("Insert ID");

        disable.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        disable.setText("Disable");
        disable.setRequestFocusEnabled(false);
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                disableMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(insertID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(enable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete))
                    .addComponent(disable))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertID)
                    .addComponent(disable))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(enable)
                    .addComponent(delete))
                .addGap(28, 28, 28))
        );

        feedback.setBackground(new java.awt.Color(51, 51, 51));
        feedback.setForeground(new java.awt.Color(102, 102, 102));
        feedback.setText("Temporary Text");
        feedback.setRequestFocusEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(home)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(backups)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home)
                    .addComponent(jLabel1)
                    .addComponent(backups))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(feedback)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        nt.panel01.setVisible(true);
        nt.panel02.setVisible(false);
        this.setVisible(false);
    }//GEN-LAST:event_homeMouseClicked

    private void backupsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupsMouseClicked
        nt.panel01.setVisible(false);
        nt.panel02.setVisible(true);
        this.setVisible(false);
        backupsPanel.displayData();
    }//GEN-LAST:event_backupsMouseClicked

    private void deleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMousePressed
        enable.setSelected(false);
        disable.setSelected(false);
        if(delete.isSelected()){
            delete.setSelected(true);
        }else{
            delete.setSelected(false);
        }
    }//GEN-LAST:event_deleteMousePressed

    private void enableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enableMousePressed
        delete.setSelected(false);
        disable.setSelected(false);
        if(enable.isSelected()){
            enable.setSelected(true);
        }else{
            enable.setSelected(false);
        }
    }//GEN-LAST:event_enableMousePressed

    private void disableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableMousePressed
        delete.setSelected(false);
        enable.setSelected(false);
        if(disable.isSelected()){
            disable.setSelected(true);
        }else{
            disable.setSelected(false);
        }
    }//GEN-LAST:event_disableMousePressed

    
    private void insertIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertIDActionPerformed
        database data = DatabaseAutorun.connect();
        var queue = data.getAllData();
        var value = 0;
        try{
            feedback.setVisible(false);
            value = Integer.parseInt(evt.getActionCommand());
            if(value > 1000){
                intoFeedback("out of limit 1000 in ID!");
                intoTerminal("\n[autorun] out of limit 1000 in ID!");
                return;
            }
        }catch(NumberFormatException ex){
            intoFeedback("Invalid ID with string!");
            intoTerminal("\n[autorun] Invalid ID with string!");
            return;
        }
        
        /**
         * checkpoint: if id number is exists
         */
        var isExists = false;
        var info = new startup();
        for(int i = 0; i < queue.size();++i){
            var db = (startup)queue.toArray()[i];
            if(db.id == value){
                isExists = true;
                info = db;
                break;
            }
        }
        //end
        var file = new File(info.fullname);
        
        /**
         * checkpoint: if still file exists or not
         */
        if(!file.exists()){
            data.delete(value);
            intoReg(file,reg.delete);
            intoTerminal("[autorun] unexpected deletion of data name '"+file.getName()+"' because it doesn't exists!");
            displayData();
            return;
        }
        //end
        
        if(disable.isSelected() && isExists){
            try{
                info.status = "disable";
                data.update(info);
                intoReg(file,reg.delete);//only delete into register data not in database
                insertID.setText(null);
            }catch(java.sql.SQLException ex){
                Logger.getLogger(autorunPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(enable.isSelected() && isExists){
            try{
                info.status = "enable";
                data.update(info);
                intoReg(file,reg.insert);//
                insertID.setText(null);
            }catch(java.sql.SQLException ex){
                Logger.getLogger(autorunPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(delete.isSelected() && isExists){
            data.delete(value);
            intoReg(file,reg.delete);
            delete.setSelected(false);
            insertID.setText(null);
        }else{
            intoFeedback("Invalid ID!");
            intoTerminal("\n[autorun] Invalid ID!");
            return;
        }
        displayData();
    }//GEN-LAST:event_insertIDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backups;
    private javax.swing.JCheckBox delete;
    private javax.swing.JCheckBox disable;
    private javax.swing.JCheckBox enable;
    private javax.swing.JLabel feedback;
    private javax.swing.JLabel home;
    private javax.swing.JTextField insertID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}

enum reg{
    insert,
    delete
}