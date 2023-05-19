package tool;

public class frameExtention extends javax.swing.JFrame {
    private home nt;
    public frameExtention(home nt) {
        this.nt = nt;
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bodyMenu = new javax.swing.JPanel();
        pin = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        setting = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setFocusableWindowState(false);
        setUndecorated(true);
        setResizable(false);

        bodyMenu.setBackground(new java.awt.Color(51, 51, 51));
        bodyMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        bodyMenu.setForeground(new java.awt.Color(255, 255, 255));

        pin.setFont(new java.awt.Font("Segoe MDL2 Assets", 0, 14)); // NOI18N
        pin.setForeground(new java.awt.Color(255, 204, 102));
        pin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pin.setText("<html><h3></h3></html>");
        pin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pin.setMaximumSize(new java.awt.Dimension(25, 25));
        pin.setMinimumSize(new java.awt.Dimension(25, 25));
        pin.setPreferredSize(new java.awt.Dimension(25, 25));
        pin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pinMousePressed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Segoe MDL2 Assets", 0, 14)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 204, 102));
        exitButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitButton.setText("<html><h3></h3></html>");
        exitButton.setAlignmentX(0.5F);
        exitButton.setFocusCycleRoot(true);
        exitButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitButton.setMaximumSize(new java.awt.Dimension(25, 25));
        exitButton.setMinimumSize(new java.awt.Dimension(25, 25));
        exitButton.setPreferredSize(new java.awt.Dimension(25, 25));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitButtonMousePressed(evt);
            }
        });

        setting.setFont(new java.awt.Font("Segoe MDL2 Assets", 0, 14)); // NOI18N
        setting.setForeground(new java.awt.Color(255, 204, 102));
        setting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setting.setText("<html><h3></h3></html>");
        setting.setAlignmentX(0.5F);
        setting.setFocusCycleRoot(true);
        setting.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setting.setMaximumSize(new java.awt.Dimension(25, 25));
        setting.setMinimumSize(new java.awt.Dimension(25, 25));
        setting.setPreferredSize(new java.awt.Dimension(25, 25));
        setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                settingMousePressed(evt);
            }
        });

        javax.swing.GroupLayout bodyMenuLayout = new javax.swing.GroupLayout(bodyMenu);
        bodyMenu.setLayout(bodyMenuLayout);
        bodyMenuLayout.setHorizontalGroup(
            bodyMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        bodyMenuLayout.setVerticalGroup(
            bodyMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyMenuLayout.createSequentialGroup()
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMousePressed
        DatabaseBackup.connect().close();
        nt.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_exitButtonMousePressed

    static boolean isPin = true;
    private void pinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pinMousePressed
        var ico = "";
        if(isPin){
            isPin = false;
            nt.setAlwaysOnTop(true);
            this.setAlwaysOnTop(true);
            
            ico = "<html><h3>"+(char)59456+"</h3></html>";
        }else{
            isPin = true;
            nt.setAlwaysOnTop(false);
            this.setAlwaysOnTop(false);
            
            ico = "<html><h3>"+(char)57665+"</h3></html>";
        }
        pin.setText(ico);
    }//GEN-LAST:event_pinMousePressed

    private void settingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_settingMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyMenu;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel pin;
    private javax.swing.JLabel setting;
    // End of variables declaration//GEN-END:variables
}
