package tool;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class backupsPanel extends javax.swing.JPanel {
    private home nt;
    private static DefaultTableModel tbl;
    
    public backupsPanel(home nt) {
        this.nt = nt;
        initComponents();
        
        feedback.setText(null);
        tbl = (DefaultTableModel)table.getModel();
        brows.setVisible(false);
        saveall.setVisible(false);
        delall.setVisible(false);
    }
    
    protected void intoTerminal(String display){
        nt.outText+= display;
        nt.terminal.setText(nt.outText);
    }
    protected void intoFeedback(String display){
        feedback.setVisible(true);
        feedback.setText(display);
    }

    
    public static void backup(String filename,home nt){
        try{
            database data = DatabaseBackup.connect();
            var backupVar = new backup();
            var rand = new Random();
            final var md5 = MessageDigest.getInstance("MD5");
            var file = new File(filename);
            
            //set data
            backupVar.id = (100 + rand.nextInt(900));
            var name = (file.getName()+"-"+backupVar.id).getBytes();
            
            backupVar.origName = file.getAbsolutePath();
            
            var md5Bytes = md5.digest(name);
            var md5String = "";
            for(var b: md5Bytes){
                md5String += String.format("%02x", b);
            }
            backupVar.identName = md5String;
            
            backupVar.size = (int)file.length();
            //end
            
            //create folder of not exists
            var dir = Paths.get("repository");
            if(!Files.exists(dir)){
                Files.createDirectory(dir);
            }//end
            
            //check file is already exists
            nt.intoTerminal("\nchecking file ");
            var thread = Need.progressAni(nt,100);
            
            var content1 = Files.readAllBytes(file.toPath());
            for(var f: dir.toFile().listFiles()){
                if(f.isFile()){
                   
                    var content2 = Files.readAllBytes(f.toPath());
                    //if not equal, meaning the file is stored in backup
                    if(Arrays.equals(content1, content2)){
                        thread.stop();
                        nt.intoTerminal("\nthe file '"+(new File(backupVar.origName).getName())+"' is already stored.");
                        return;
                    }
                }
            }
            thread.stop();
            //end
            
            try{
                data.insert(backupVar);
                Thread.sleep(50);
                data.update(backupVar);//need update to make sure the data is there
            }catch(SQLException ex){
                backup(filename,nt);
            } catch (InterruptedException ex) {
                //ignored
            }
            
            //make sure if the data is added first to data base
            nt.intoTerminal("\nchecking into database ");
            thread = Need.progressAni(nt,100);
            
            var queue = data.getAllData();
            var isExistsInDB = false;
            while(!queue.isEmpty()){
                var bkp = (backup)queue.poll();
                if(bkp.id == backupVar.id){
                    isExistsInDB = true;
                    break;
                }
            }
            thread.stop();
            
            if(!isExistsInDB){
                data.delete(backupVar.id);
                nt.intoTerminal("\nsomething wrong into database.. ");
                return;
            }
            //end
            
            //get a copy of file
            try{
                nt.intoTerminal("\nCoping the data ");
                thread = Need.progressAni(nt,100);
                var newFile = dir.resolve(backupVar.identName);
                Files.copy(file.toPath(), newFile);
                thread.stop();
                nt.intoTerminal("\nstored in to repository..");
            }catch(IOException ex){
                
            }//end
            
        }catch(IOException | NoSuchAlgorithmException ex){
            Logger.getLogger(DatabaseBackup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void displayData(){
        tbl.setRowCount(0);
        database data = DatabaseBackup.connect();
        var queue = data.getAllData();
        
        for(var i0 = 0;!queue.isEmpty();++i0){
            var db = (backup)queue.poll();
            
            Object obj[] = {db.id,
                            (new File(db.origName).getName()),
                            Need.byteSizing(db.size)};
            
            for(int i1 = 0; i1 < obj.length; ++i1){
                valueAt(obj[i1],i0,i1);
            }
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

        panelButton02 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        autorun = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        insertID = new javax.swing.JTextField();
        delete = new javax.swing.JCheckBox();
        save = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        feedback = new javax.swing.JLabel();
        brows = new javax.swing.JLabel();
        saveall = new javax.swing.JLabel();
        delall = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 51)));
        setFocusTraversalPolicyProvider(true);
        setMaximumSize(new java.awt.Dimension(522, 372));
        setMinimumSize(new java.awt.Dimension(522, 372));
        setPreferredSize(new java.awt.Dimension(522, 372));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        panelButton02.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        panelButton02.setText("Backups");
        panelButton02.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        home.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        home.setText("Home");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });

        autorun.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        autorun.setText("Autorun");
        autorun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                autorunMouseClicked(evt);
            }
        });

        table.setBackground(new java.awt.Color(102, 102, 102));
        table.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FILE NAME", "SIZE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(2).setMinWidth(80);
            table.getColumnModel().getColumn(2).setPreferredWidth(80);
            table.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        insertID.setActionCommand(null);
        insertID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        insertID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        insertID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                insertIDMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                insertIDMousePressed(evt);
            }
        });
        insertID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertIDActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        delete.setText("Delete");
        delete.setRequestFocusEnabled(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        save.setText("Save");
        save.setRequestFocusEnabled(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel1.setText("Insert ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(insertID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete)
                    .addComponent(save))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(insertID))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(delete))
                .addGap(28, 28, 28))
        );

        feedback.setBackground(new java.awt.Color(51, 51, 51));
        feedback.setForeground(new java.awt.Color(102, 102, 102));
        feedback.setText("Temporary Text");
        feedback.setRequestFocusEnabled(false);

        brows.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        brows.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brows.setText("Open File");
        brows.setAlignmentX(0.5F);
        brows.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        brows.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        brows.setOpaque(true);
        brows.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                browsMousePressed(evt);
            }
        });

        saveall.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        saveall.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saveall.setText("Save All");
        saveall.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        saveall.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveall.setOpaque(true);
        saveall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveallMousePressed(evt);
            }
        });

        delall.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        delall.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delall.setText("Delete All");
        delall.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        delall.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delall.setOpaque(true);
        delall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                delallMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(home)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelButton02)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(autorun))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 314, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(delall, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveall, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brows, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home)
                    .addComponent(autorun)
                    .addComponent(panelButton02))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brows)
                    .addComponent(saveall)
                    .addComponent(delall))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(feedback)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        this.setVisible(false);
        nt.panel01.setVisible(true);
        nt.panel03.setVisible(false);
        insertID.setEnabled(true);
    }//GEN-LAST:event_homeMouseClicked

    private void autorunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autorunMouseClicked
        nt.panel01.setVisible(false);
        this.setVisible(false);
        nt.panel03.setVisible(true);
        insertID.setEnabled(true);
        autorunPanel.displayData();
    }//GEN-LAST:event_autorunMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        save.setSelected(false);
        saveall.setVisible(false);
        if(delete.isSelected()){
            delall.setVisible(true);
        }else{
            delall.setVisible(false);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        delete.setSelected(false);
        delall.setVisible(false);
        if(save.isSelected()){
            saveall.setVisible(true);
        }else{
            saveall.setVisible(false);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void insertIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertIDActionPerformed
        database data = DatabaseBackup.connect();
        var dbQueue = data.getAllData();
        var value = 0;
        try{
            feedback.setVisible(false);
            value = Integer.parseInt(evt.getActionCommand());
            if(value > 1000){
                intoFeedback("out of limit 1000 in ID!");
                intoTerminal("\n[backup] out of limit 1000 in ID!");
                return;
            }
        }catch(NumberFormatException ex){
            intoFeedback("Invalid ID with string!");
            intoTerminal("\n[backup] Invalid ID with string!");
            return;
        }        
        
        /**
         * checkpoint: if id number is exists
         */
        var isExists = false;
        var info = new backup();
        for(int i = 0; i < dbQueue.size();++i){
            var db = (backup)dbQueue.toArray()[i];
            if(db.id == value){
                isExists = true;
                info = db;
                break;
            }
        }
        //end
        
        if(delete.isSelected() && isExists){
            intoFeedback("Progressing...");
            var thread = Need.progressAni(nt);
            data.delete(value);
            try{
                insertID.setEnabled(false);
                Files.delete( Paths.get("repository/"+info.identName));
                Thread.sleep(100);
                thread.stop();
                displayData();
                intoFeedback("Deleted!");    
            }catch(InterruptedException | IOException ex){
                thread.stop();
                intoFeedback("Somting wrong..");
                return;
            }
            insertID.setEnabled(true);
            insertID.setText(null);
            delete.setSelected(false);
            
            
        }else if(save.isSelected() && isExists){
            intoFeedback("Progressing...");
            try{
                insertID.setEnabled(false);
                //create folder of not exists
                var dir = Paths.get("c:\\repository");
                if(!Files.exists(dir)){
                    Files.createDirectory(dir);
                }//end
                
                
                intoFeedback("Saving...");
                var savedFile = dir.resolve((new File(info.origName).getName()));
                var sourceFile = Paths.get("repository\\"+info.identName);
                Files.copy(sourceFile, savedFile);
                intoFeedback("Saved! see terminal for location or click open file.");
                intoTerminal("\n[backup] Saved! to $c:\\repository"+info.origName);
            }catch(IOException ex){
                intoFeedback("Its already exists, see terminal for location or click open file.");
                intoTerminal("\n[backup] Its already exists into $c:\\repository"+info.origName);
            }
            insertID.setEnabled(true);
            insertID.setText(null);
            delete.setSelected(false);
            brows.setVisible(true);
            
        }else{
            intoFeedback("Invalid ID!");
            intoTerminal("\n[backup] Invalid ID!");
        }
        
        
    }//GEN-LAST:event_insertIDActionPerformed

    private void insertIDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertIDMouseEntered
        intoFeedback("Input ID Number and Enter key to submit.");
    }//GEN-LAST:event_insertIDMouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        feedback.setVisible(false);
    }//GEN-LAST:event_formMouseEntered

    private void browsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browsMousePressed
        var thread = Need.progressAni(nt);
        intoFeedback("Wait for a second to open file.");
        intoTerminal("\n[backup] Wait for a second to open file ");
        Need.cmd("start c:\\repository");
        thread.stop();
    }//GEN-LAST:event_browsMousePressed

    private void insertIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertIDMousePressed
        brows.setVisible(false);
    }//GEN-LAST:event_insertIDMousePressed

    private void delallMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delallMousePressed
        nt.executor.submit(()->{
            database data = DatabaseBackup.connect();
            var dbQueue = data.getAllData();
        
            intoFeedback("Progressing deletion activity...");
            intoTerminal("\n[backup] Progressing deletion activity...");
            for(var queue: dbQueue.toArray()){
                try {
                    var db = (backup)queue;
                    intoTerminal(String.format("\n[backup] file '%s' is ",(new File(db.origName).getName())));
                    var thread = Need.progressAni(nt);
                    Files.delete( Paths.get("repository/"+db.identName));//delete into file repository
                    Thread.sleep(50);
                    data.delete(db.id);//delete into DatabaseBackup
                    intoTerminal("deleted ");
                    thread.stop();
                    Thread.sleep(50);
                    displayData();
                } catch (InterruptedException | IOException ex) {
                    Logger.getLogger(backupsPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //delete directory and create new 
            try{
                var path = Paths.get("repository");
                Files.delete(path);
                if(Files.exists(path)){
                    Files.createDirectories(path);
                }
            }catch(Exception ex){}
            //end
            intoFeedback("Deletion done!");
            delete.setSelected(false);
            delall.setVisible(false);
        });
    }//GEN-LAST:event_delallMousePressed

    private void saveallMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveallMousePressed
        database data = DatabaseBackup.connect();
        var dbQueue = data.getAllData();
        
        intoFeedback("Progressing Saving all file activity...");
        intoTerminal("\n[backup] Progressing saving all file activity...");
        
        for(var queue: dbQueue.toArray()){
            var thread = Need.progressAni(nt);
            try {
                Thread.sleep(50);
                var db = (backup)queue;
                intoTerminal(String.format("\n[backup] file '%s' is ",(new File(db.origName).getName())));
                
                
                //create folder of not exists
                var dir = Paths.get("c:\\repository");
                if(!Files.exists(dir)){
                    Files.createDirectory(dir);
                }//end
                
                var savedFile = dir.resolve((new File(db.origName).getName()));
                var sourceFile = Paths.get("repository\\"+db.identName);
                Files.copy(sourceFile, savedFile);
                
                intoTerminal("saved! ");
                thread.stop();
            } catch (InterruptedException | IOException ex) {
                intoTerminal("is already exists! ");
                thread.stop();
            }
        }
        intoFeedback("Saving All is done!");
        brows.setVisible(true);
    }//GEN-LAST:event_saveallMousePressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel autorun;
    private javax.swing.JLabel brows;
    private javax.swing.JLabel delall;
    private javax.swing.JCheckBox delete;
    private javax.swing.JLabel feedback;
    private javax.swing.JLabel home;
    private javax.swing.JTextField insertID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel panelButton02;
    private javax.swing.JCheckBox save;
    private javax.swing.JLabel saveall;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
