package tool;

import java.util.concurrent.Executors;
import java.io.File;
import java.util.concurrent.ExecutorService;

public class home extends javax.swing.JFrame {

    protected javax.swing.JPanel panel02 = null;
    protected javax.swing.JPanel panel03 = null;
    private frameExtention m ;
    private int x = 0,y = 0;//set and get the location coordination
    static String outText = "";//
    protected ExecutorService executor = Executors.newFixedThreadPool(4);
    
    private void checkOS(){
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            // Windows
            intoTerminal("Running windows, all feture");
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            // Linux, Unix, or macOS
            intoTerminal("not supported feture autorun");
        } else {
            // Other OS
            intoTerminal("not supported feture autorun");
        }
    }
    
    public home() {
        panel02 = new backupsPanel(this);
        panel03 = new autorunPanel(this);
        initComponents();
        
        checkOS();
        
        (m = new frameExtention(this)).setVisible(false);
        feedback.setVisible(false);
        inputPath.setActionCommand(null);// i set this null to fix the bug of jTextField
        
        var mPanelLayout = (javax.swing.GroupLayout) focusPanel.getLayout();
        focusPanel.setLayout(mPanelLayout);
        
        mPanelLayout.setHorizontalGroup(
                mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        mPanelLayout.setVerticalGroup(
                mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        
        panel01.setVisible(true);
        panel02.setVisible(false);
        panel03.setVisible(false);
    }
    
    /**
     * @see intoTerminal
     * @see intoFeedBack
     * this section is displaying text into GUI
     */
    protected void intoTerminal(String display){
        outText+= display;
        terminal.setText(outText);
    }
    protected void intoFeedback(String display){
        feedback.setVisible(true);
        feedback.setText(display);
    }//end
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mPanel = new javax.swing.JPanel();
        focusPanel = new javax.swing.JPanel();
        panel01 = new javax.swing.JPanel();
        HomeButton = new javax.swing.JLabel();
        BackupsButton = new javax.swing.JLabel();
        AutorunButton = new javax.swing.JLabel();
        handlerPanel1 = new javax.swing.JPanel();
        inputPath = new javax.swing.JTextField();
        terminalOutput = new javax.swing.JScrollPane();
        terminal = new javax.swing.JTextArea();
        handleTheButtons = new javax.swing.JPanel();
        encrypt = new javax.swing.JCheckBox();
        decrypt = new javax.swing.JCheckBox();
        backups = new javax.swing.JCheckBox();
        autorun = new javax.swing.JCheckBox();
        feedback = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        version = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(522, 401));
        setUndecorated(true);
        setResizable(false);

        mPanel.setBackground(new java.awt.Color(51, 51, 51));
        mPanel.setForeground(new java.awt.Color(102, 102, 102));
        mPanel.setMaximumSize(new java.awt.Dimension(522, 401));
        mPanel.setMinimumSize(new java.awt.Dimension(522, 401));
        mPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mPanelMouseDragged(evt);
            }
        });
        mPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mPanelMousePressed(evt);
            }
        });

        focusPanel.setMaximumSize(new java.awt.Dimension(522, 372));
        focusPanel.setMinimumSize(new java.awt.Dimension(522, 372));

        panel01.setBackground(new java.awt.Color(204, 204, 204));
        panel01.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 153, 51)));
        panel01.setMaximumSize(new java.awt.Dimension(522, 372));
        panel01.setMinimumSize(new java.awt.Dimension(522, 372));
        panel01.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panel01mouseMoved(evt);
            }
        });
        panel01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel01MouseEntered(evt);
            }
        });

        HomeButton.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        HomeButton.setText("Home");
        HomeButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 153, 51)));

        BackupsButton.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        BackupsButton.setText("Backups");
        BackupsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackupsButtonMouseClicked(evt);
            }
        });

        AutorunButton.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        AutorunButton.setText("Autorun");
        AutorunButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AutorunButtonMouseClicked(evt);
            }
        });

        handlerPanel1.setBackground(new java.awt.Color(204, 204, 204));
        handlerPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                handlerPanel1mouseMoved(evt);
            }
        });

        inputPath.setBackground(new java.awt.Color(204, 204, 204));
        inputPath.setColumns(20);
        inputPath.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        inputPath.setForeground(new java.awt.Color(102, 102, 102));
        inputPath.setActionCommand(""); // NOI18N
        inputPath.setAutoscrolls(false);
        inputPath.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        inputPath.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        inputPath.setDropMode(javax.swing.DropMode.INSERT);
        inputPath.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        inputPath.setSelectionColor(new java.awt.Color(243, 191, 104));
        inputPath.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inputPathMousePressed(evt);
            }
        });
        inputPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPathActionPerformed(evt);
            }
        });
        inputPath.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputPathKeyTyped(evt);
            }
        });

        terminalOutput.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        terminal.setEditable(false);
        terminal.setBackground(new java.awt.Color(51, 51, 51));
        terminal.setColumns(20);
        terminal.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        terminal.setForeground(new java.awt.Color(204, 204, 204));
        terminal.setLineWrap(true);
        terminal.setRows(5);
        terminal.setAutoscrolls(false);
        terminal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, new java.awt.Color(255, 153, 51)));
        terminal.setMaximumSize(new java.awt.Dimension(142, 62));
        terminal.setMinimumSize(new java.awt.Dimension(142, 62));
        terminal.setRequestFocusEnabled(false);
        terminal.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        terminal.setSelectionColor(new java.awt.Color(243, 191, 104));
        terminal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                terminalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                terminalMouseExited(evt);
            }
        });
        terminalOutput.setViewportView(terminal);

        handleTheButtons.setBackground(new java.awt.Color(204, 204, 204));

        encrypt.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        encrypt.setText("Lock");
        encrypt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        encrypt.setFocusPainted(false);
        encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptActionPerformed(evt);
            }
        });

        decrypt.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        decrypt.setText("unLock");
        decrypt.setFocusPainted(false);
        decrypt.setFocusable(false);
        decrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptActionPerformed(evt);
            }
        });

        backups.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        backups.setText("Backup repository");
        backups.setFocusPainted(false);
        backups.setFocusable(false);
        backups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupsActionPerformed(evt);
            }
        });

        autorun.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        autorun.setText("Auto execute code");
        autorun.setFocusPainted(false);
        autorun.setFocusable(false);
        autorun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autorunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout handleTheButtonsLayout = new javax.swing.GroupLayout(handleTheButtons);
        handleTheButtons.setLayout(handleTheButtonsLayout);
        handleTheButtonsLayout.setHorizontalGroup(
            handleTheButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, handleTheButtonsLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(handleTheButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(encrypt)
                    .addComponent(decrypt))
                .addGap(43, 43, 43)
                .addGroup(handleTheButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(autorun)
                    .addComponent(backups))
                .addGap(31, 31, 31))
        );
        handleTheButtonsLayout.setVerticalGroup(
            handleTheButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(handleTheButtonsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(handleTheButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encrypt)
                    .addComponent(backups))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(handleTheButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decrypt)
                    .addComponent(autorun))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout handlerPanel1Layout = new javax.swing.GroupLayout(handlerPanel1);
        handlerPanel1.setLayout(handlerPanel1Layout);
        handlerPanel1Layout.setHorizontalGroup(
            handlerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(handlerPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(handlerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(handlerPanel1Layout.createSequentialGroup()
                        .addComponent(terminalOutput)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, handlerPanel1Layout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addGroup(handlerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(handleTheButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPath, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))))
        );
        handlerPanel1Layout.setVerticalGroup(
            handlerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(handlerPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(inputPath, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(handleTheButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(terminalOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        feedback.setBackground(new java.awt.Color(51, 51, 51));
        feedback.setForeground(new java.awt.Color(102, 102, 102));
        feedback.setText("Temporary Text");
        feedback.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panel01Layout = new javax.swing.GroupLayout(panel01);
        panel01.setLayout(panel01Layout);
        panel01Layout.setHorizontalGroup(
            panel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel01Layout.createSequentialGroup()
                .addGroup(panel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel01Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(HomeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel01Layout.createSequentialGroup()
                                .addComponent(BackupsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AutorunButton))
                            .addComponent(handlerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel01Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panel01Layout.setVerticalGroup(
            panel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HomeButton)
                    .addComponent(BackupsButton)
                    .addComponent(AutorunButton))
                .addGap(18, 18, 18)
                .addComponent(handlerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(feedback)
                .addContainerGap())
        );

        javax.swing.GroupLayout focusPanelLayout = new javax.swing.GroupLayout(focusPanel);
        focusPanel.setLayout(focusPanelLayout);
        focusPanelLayout.setHorizontalGroup(
            focusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        focusPanelLayout.setVerticalGroup(
            focusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menu.setFont(new java.awt.Font("Segoe MDL2 Assets", 0, 14)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 204, 102));
        menu.setText("<html><h2></h2></html>");
        menu.setMaximumSize(new java.awt.Dimension(16, 16));
        menu.setMinimumSize(new java.awt.Dimension(16, 16));
        menu.setPreferredSize(new java.awt.Dimension(16, 16));
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuMouseEntered(evt);
            }
        });

        title.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("CryptBlack Repository");

        version.setForeground(new java.awt.Color(153, 153, 153));
        version.setText("version 1.0.0");

        javax.swing.GroupLayout mPanelLayout = new javax.swing.GroupLayout(mPanel);
        mPanel.setLayout(mPanelLayout);
        mPanelLayout.setHorizontalGroup(
            mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mPanelLayout.createSequentialGroup()
                .addComponent(focusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(mPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(version)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        mPanelLayout.setVerticalGroup(
            mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(title)
                        .addComponent(version)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(focusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     */
    private void BackupsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackupsButtonMouseClicked
        panel01.setVisible(false);
        panel02.setVisible(true);
        panel03.setVisible(false);
        backupsPanel.displayData();
    }//GEN-LAST:event_BackupsButtonMouseClicked

    private void AutorunButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutorunButtonMouseClicked
        panel01.setVisible(false);
        panel02.setVisible(false);
        panel03.setVisible(true);
        autorunPanel.displayData();
    }//GEN-LAST:event_AutorunButtonMouseClicked
    //end
    
    private void inputPathMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputPathMousePressed
        feedback.setVisible(true);
        feedback.setText("insert file or folder directory and enter if you want to submit.");
    }//GEN-LAST:event_inputPathMousePressed

    /**
     * @see inputPathActionPerformed
     * this method is action method,
     */
    
    private void inputPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPathActionPerformed
        /**
         * if ever multiple file use semicolon to separate,
         * i use for loop to run one by one
         */
        var paths = evt.getActionCommand().split(";");
        boolean isNoError = false,oneTime = true;
        //end
        
        //mini command for gui
        if(paths[0].equalsIgnoreCase("clear")){
            outText = "";
            terminal.setText(outText);//clear in terminal
            inputPath.setText(outText);//clear in input
            return;
        }
        //end command
        
        /**
         * checkpoint: make sure if multiple path is always file, 
         * do not continue if one is not exists or is directory
         */
        if(paths.length > 1){
            intoTerminal("\nmultiple path checkpoint ");
            var thread = Need.progressAni(this,100);
            var isNotValid = false;
            for(var arr: paths){
                var file = new File(arr);
                
                if(file.isDirectory() || (!file.exists())){
                    isNotValid = true;
                    break;
                }
            }
            thread.stop();
            if(isNotValid){
                intoTerminal("\ninvalid, try to check your entered!");
                return;
            }else{
                intoTerminal("\nall valid :)");
            }
        }
        //end
        
        /**
         * checkpoint: if you entered only without 
         * any character it will stop and warning you
         */
        if((evt.getActionCommand().toCharArray().length) == 0){
            feedback.setVisible(true);
            feedback.setText("warning - you need to write any word before to enter!");
            return;
        }//end
        
        /**
         * if only one path and its a directory,
         * the task of this next code is to get 
         * all file inside of entered directory
         */
        var currentPath = (new File("")).getAbsolutePath();
        if((new File(paths[0])).isDirectory()){
            
            
            var files = new File(paths[0]).listFiles();
            
            /**
             * checkpoint: test if folder is empty
             */
            if(files == null){
                intoTerminal("\nwarning - directory entered is empty file!");
                return;
            }
            //end
            
            paths = new String[files.length];
            for(int i = 0,j = 0; i < paths.length;++i){
                if(files[i].isFile()){
                    paths[j] = files[i].getAbsolutePath();
                    ++j;
                }
            }
            
        }//end
        
        /**
         * another checkpoint if all entered path is perfectly exists
         */
        for(var path: paths){
            try{
                var file = new File(path);
                if(!file.exists()){
                    intoTerminal("\nill stop the task because this '"+file.getName()+"' is not exists!");
                    return;
                }
            }catch(java.lang.NullPointerException ex){
                intoTerminal("\nwarning - directory entered is empty file!");
                return;
            }
        }
        //end
        
        
        final var fileList = paths;
        
        //do the action
        if(encrypt.isSelected()){
            diSelect();
            executor.submit(()->{
                inputPath.setEnabled(false);
                    
                var i = 0;
                var addList = new String[fileList.length];
                for(var path: fileList){
                    outText = "\nEncrypting Progress..";//reset
                    var cfile = new CryptFile(path,this);
                    var name = (new File(cfile.getFullPath()).getName());
                    if(name.length() >= 45){
                        name = name.substring(0, 45)+"..";
                    }
                    terminal.setText(outText+"\nfile: "+name);
                    cfile.cryptStart(CryptFile.ENCRYPT);
                    if(cfile.getErrorMSG() != null){
                        intoTerminal("\nerror["+i+"] - "+cfile.getErrorMSG());
                    }else{
                        addList[i] = name;
                        ++i;//count
                    }
                    outText = "";
                }
                intoTerminal("\nEncrypting Progress..\nSuccessful file encrypt!");
                for(var f: addList){
                    intoTerminal("\n "+f);
                }
                inputPath.setEnabled(true);
            });
        }else if(decrypt.isSelected()){
            diSelect();
            executor.submit(()->{
                inputPath.setEnabled(false);
                    
                var i = 0;
                var addList = new String[fileList.length];
                for(var path: fileList){
                    outText = "\nDecrypting Progress..";//reset
                    var cfile = new CryptFile(path,this);
                    var name = (new File(cfile.getFullPath()).getName());
                    if(name.length() >= 45){
                        name = name.substring(0, 45)+"..";
                    }
                    terminal.setText(outText+"\nfile: "+name);
                    cfile.cryptStart(CryptFile.DECRYPT);
                    if(cfile.getErrorMSG() != null){
                        intoTerminal("\nerror["+i+"] - "+cfile.getErrorMSG());
                    }else{
                        addList[i] = name;
                        ++i;//count
                    }
                    outText = "";
                }
                intoTerminal("\nDecrypting Progress..\nSuccessful file decrypt!");
                for(var f: addList){
                    intoTerminal("\n "+f);
                }
                inputPath.setEnabled(true);
            });
        }else if(backups.isSelected()){
            diSelect();
            executor.submit(()->{
                inputPath.setEnabled(false);
                
                var i = 0;
                var addList = new String[fileList.length];
                for(var path: fileList){
                    outText = "\nPrefer Backup File Progressing..";//reset
                    var name = (new File(path).getName());
                    if(name.length() >= 45){
                        name = name.substring(0, 45)+"..";
                    }
                    terminal.setText(outText+"\nfile: "+name);
                    
                    backupsPanel.backup(path, this);
                    addList[i] = name;
                    ++i;
                    outText = "";
                }
                intoTerminal("\nPrefer Backup File Progressing..\nSuccessful file backups!");
                for(var f: addList){
                    intoTerminal("\n "+f);
                }
                inputPath.setEnabled(true);
            });
        }else if(autorun.isSelected()){
            diSelect();
            executor.submit(()->{
                inputPath.setEnabled(false);
                
                var i = 0;
                var addList = new String[fileList.length];
                var bool = false;
                for(var path: fileList){
                    outText = "\nPrefer Autorun File Progressing..";//reset
                    var name = (new File(path).getName());
                    if(name.length() >= 45){
                        name = name.substring(0, 45)+"..";
                    }
                    terminal.setText(outText+"\nfile: "+name);
                    
                    if(testExt((new File(path).getName()))){
                        autorunPanel.autorun(path, this);
                        addList[i] = name;
                        ++i;
                        bool = true;
                    }
                    outText = "";
                }
                intoTerminal("\nPrefer Autorun File Progressing..\nSuccessful Setting autorun!");
                if(bool){
                    for(var f: addList){
                        if(f != null){
                            intoTerminal("\n "+f);
                        }
                    }
                }else{
                    intoTerminal("\nits look not match in requirements!");
                }
                inputPath.setEnabled(true);
            });
        }else{
            intoTerminal("\nwarning - before you enter makes sure action is selected.");
        }
        
    }//GEN-LAST:event_inputPathActionPerformed
    //end
    
    /**
     * this function is for finding valid extension for Action Autorun
     */
    static boolean testExt(String path){
        Object obj[][] = {
            {".exe",4},
            {".bat",4},
            {".js",3},
            {".vbc",4}
        };
        
        for(int i = 0; i < obj.length;++i){
            if((path.substring(path.length()-(int)obj[i][1]).equalsIgnoreCase((String)obj[i][0])) && path.contains( (String)obj[i][0])){
                return true;
            }
        }
        
        return false;
    }//end
    
    private void terminalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_terminalMouseEntered
        feedback.setVisible(true);
        feedback.setText("terminal output");
        inputPath.setEnabled(false);
    }//GEN-LAST:event_terminalMouseEntered

    private void terminalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_terminalMouseExited
        inputPath.setEnabled(true);
    }//GEN-LAST:event_terminalMouseExited

    private void handlerPanel1mouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_handlerPanel1mouseMoved
        feedback.setVisible(false);
    }//GEN-LAST:event_handlerPanel1mouseMoved

    private void panel01mouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel01mouseMoved
        feedback.setVisible(false);
        menu.setText("<html><h2>"+(char)59232+"</h2></html>");
    }//GEN-LAST:event_panel01mouseMoved

    private void panel01MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel01MouseEntered
        m.setVisible(false);
        menu.setText("<html><h2>"+(char)59232+"</h2></html>");
    }//GEN-LAST:event_panel01MouseEntered

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        m.setLocation((this.getLocation().x+mPanel.getWidth())+5,this.getLocation().y);
        m.setVisible(true);
        menu.setText("<html><h2>"+(char)59233+"</h2></html>");
    }//GEN-LAST:event_menuMouseClicked

    private void menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseEntered
        m.setLocation((this.getLocation().x+mPanel.getWidth())+5,this.getLocation().y);
        m.setVisible(true);
        menu.setText("<html><h2>"+(char)59233+"</h2></html>");
    }//GEN-LAST:event_menuMouseEntered

    private void mPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mPanelMouseDragged
        this.setLocation(evt.getXOnScreen() - x,evt.getYOnScreen() - y );
        m.setVisible(false);
        menu.setText("<html><h2>"+(char)59232+"</h2></html>");
    }//GEN-LAST:event_mPanelMouseDragged

    private void mPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mPanelMousePressed
        x = evt.getX();
        y = evt.getY();
        m.setVisible(false);
        menu.setText("<html><h2>"+(char)59232+"</h2></html>");
    }//GEN-LAST:event_mPanelMousePressed

    private void encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptActionPerformed
        autorun.setSelected(false);
        backups.setSelected(false);
        decrypt.setSelected(false);
        
        outText += "\naction - "+encrypt.getText()+" selected $"+(encrypt.isSelected()? "{ON}" : "{OFF}");
        terminal.setText(outText);
    }//GEN-LAST:event_encryptActionPerformed

    //this group is for control action
    private void diSelect(){
        encrypt.setSelected(false);
        decrypt.setSelected(false);
        autorun.setSelected(false);
        backups.setSelected(false);
    }
    private void decryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptActionPerformed
        encrypt.setSelected(false);
        autorun.setSelected(false);
        backups.setSelected(false);
        outText += "\naction - "+decrypt.getText()+" selected $"+(decrypt.isSelected()? "{ON}" : "{OFF}");
        terminal.setText(outText);
    }//GEN-LAST:event_decryptActionPerformed

    private void backupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupsActionPerformed
        encrypt.setSelected(false);
        autorun.setSelected(false);
        decrypt.setSelected(false);
        outText += "\naction - "+backups.getText()+" selected $"+(backups.isSelected()? "{ON}" : "{OFF}");
        terminal.setText(outText);
    }//GEN-LAST:event_backupsActionPerformed

    private void autorunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autorunActionPerformed
        encrypt.setSelected(false);
        encrypt.setSelected(false);
        backups.setSelected(false);
        decrypt.setSelected(false);
        outText += "\naction - "+autorun.getText()+" selected $"+(autorun.isSelected()? "{ON}" : "{OFF}");
        terminal.setText(outText);
    }//GEN-LAST:event_autorunActionPerformed
    //end
    
    private void inputPathKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputPathKeyTyped
        if(!((int)evt.getKeyChar() == 10)){
            feedback.setVisible(false);
        }
    }//GEN-LAST:event_inputPathKeyTyped

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AutorunButton;
    private javax.swing.JLabel BackupsButton;
    private javax.swing.JLabel HomeButton;
    private javax.swing.JCheckBox autorun;
    private javax.swing.JCheckBox backups;
    private javax.swing.JCheckBox decrypt;
    private javax.swing.JCheckBox encrypt;
    private javax.swing.JLabel feedback;
    private javax.swing.JPanel focusPanel;
    private javax.swing.JPanel handleTheButtons;
    private javax.swing.JPanel handlerPanel1;
    private javax.swing.JTextField inputPath;
    private javax.swing.JPanel mPanel;
    private javax.swing.JLabel menu;
    protected javax.swing.JPanel panel01;
    protected javax.swing.JTextArea terminal;
    private javax.swing.JScrollPane terminalOutput;
    private javax.swing.JLabel title;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
}
