/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocommitgit.layout;

import autocommitgit.Config;
import autocommitgit.ThreadWait;
import autocommitgit.file.RWFile;
import java.io.File;
import javax.swing.JFileChooser;

/**
 * layout confi
 * @author hoaiv
 */
public class CongfigAppUI extends javax.swing.JFrame {

    /**
     * Creates new form $CongfigApp
     */
    private ThreadWait wait;
    private TrayUI tray;
    public CongfigAppUI(ThreadWait wait, TrayUI tray) {
        this.wait = wait;
        initComponents();
        
        RWFile file =  new RWFile();
        jtxtPath.setText( file.readFile() );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxtPath = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbtnChoose = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jchckAsk = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configuration");
        setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jtxtPath.setEditable(false);
        jtxtPath.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtxtPath.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Folder");

        jbtnChoose.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnChoose.setText("Choose");
        jbtnChoose.setActionCommand("");
        jbtnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnChooseActionPerformed(evt);
            }
        });

        jbtnCancel.setText("Hide");
        jbtnCancel.setActionCommand("");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jLabel2.setText("Ask");
        jLabel2.setToolTipText("Ask the massage when commit");

        jchckAsk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchckAskActionPerformed(evt);
            }
        });

        jLabel3.setText("Ask commit message.");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jchckAsk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(jtxtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnChoose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnCancel)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jtxtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnChoose)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jchckAsk)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jbtnCancel)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnChooseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(jtxtPath.getText()));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String currentPath = chooser.getCurrentDirectory().getAbsolutePath();
            File f = chooser.getSelectedFile();
            if (f.exists() && f.isDirectory()) {
                Config.path = chooser.getSelectedFile().getAbsolutePath();
            }else{
                Config.path = currentPath;
            }
             RWFile file =  new RWFile();
             file.writeFile(Config.path);
            jtxtPath.setText(Config.path);
        } else {
            System.out.println("No Selection ");
        }

    }//GEN-LAST:event_jbtnChooseActionPerformed

    private void jchckAskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchckAskActionPerformed
        Config.isAsk = jchckAsk.isSelected();
    }//GEN-LAST:event_jchckAskActionPerformed

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
        this.setVisible(false);
        RWFile file =  new RWFile();
        Config.path = file.readFile();
        if(!wait.isRun()){
            wait.start();
        }
    }//GEN-LAST:event_jbtnCancelActionPerformed
    public void setPath(String path) {
        jtxtPath.setText(path);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnChoose;
    private javax.swing.JCheckBox jchckAsk;
    private javax.swing.JTextField jtxtPath;
    // End of variables declaration//GEN-END:variables
}
