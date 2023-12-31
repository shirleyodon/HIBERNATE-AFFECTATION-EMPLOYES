/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.dialog;

/**
 *
 * @author shirleyodon
 */
public class AboutProject extends javax.swing.JDialog {

    /**
     * Creates new form AboutProject
     */
    public AboutProject(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        descriptionLabel = new javax.swing.JLabel();
        descriptionArea = new javax.swing.JTextArea();
        technologieLabel = new javax.swing.JLabel();
        technologieTextArea = new javax.swing.JTextArea();
        ideLabel = new javax.swing.JLabel();
        ideTextArea = new javax.swing.JTextArea();
        versionLabel = new javax.swing.JLabel();
        versionTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("A PROPOS");

        bodyPanel.setBackground(new java.awt.Color(33, 47, 61));

        descriptionLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(236, 240, 241));
        descriptionLabel.setText("Description");

        descriptionArea.setEditable(false);
        descriptionArea.setBackground(new java.awt.Color(108, 122, 137));
        descriptionArea.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        descriptionArea.setForeground(new java.awt.Color(228, 241, 254));
        descriptionArea.setLineWrap(true);
        descriptionArea.setRows(5);
        descriptionArea.setTabSize(40);
        descriptionArea.setText("C'est une application Java Swing de gestion d'affectations des employés. Les données sont stockées dans une base de données Mysql. La perssistance et l'accès à ces données sont gérés par un ORM.");
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setPreferredSize(new java.awt.Dimension(269, 100));

        technologieLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        technologieLabel.setForeground(new java.awt.Color(236, 240, 241));
        technologieLabel.setText("Technologie utilisée");

        technologieTextArea.setEditable(false);
        technologieTextArea.setBackground(new java.awt.Color(108, 122, 137));
        technologieTextArea.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        technologieTextArea.setForeground(new java.awt.Color(228, 241, 254));
        technologieTextArea.setLineWrap(true);
        technologieTextArea.setText("Hibernate (ORM)");
        technologieTextArea.setWrapStyleWord(true);
        technologieTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        technologieTextArea.setPreferredSize(new java.awt.Dimension(269, 24));

        ideLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        ideLabel.setForeground(new java.awt.Color(236, 240, 241));
        ideLabel.setText("IDE");

        ideTextArea.setEditable(false);
        ideTextArea.setBackground(new java.awt.Color(108, 122, 137));
        ideTextArea.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        ideTextArea.setForeground(new java.awt.Color(228, 241, 254));
        ideTextArea.setLineWrap(true);
        ideTextArea.setText("NetBeans 14");
        ideTextArea.setWrapStyleWord(true);
        ideTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ideTextArea.setPreferredSize(new java.awt.Dimension(269, 24));

        versionLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        versionLabel.setForeground(new java.awt.Color(236, 240, 241));
        versionLabel.setText("Version");

        versionTextArea.setEditable(false);
        versionTextArea.setBackground(new java.awt.Color(108, 122, 137));
        versionTextArea.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        versionTextArea.setForeground(new java.awt.Color(228, 241, 254));
        versionTextArea.setLineWrap(true);
        versionTextArea.setText("1.0");
        versionTextArea.setWrapStyleWord(true);
        versionTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        versionTextArea.setPreferredSize(new java.awt.Dimension(269, 24));

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ideTextArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(versionTextArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(technologieTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(technologieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ideLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(versionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(descriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descriptionArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(technologieLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(technologieTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ideLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ideTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(versionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(versionTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AboutProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AboutProject dialog = new AboutProject(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel ideLabel;
    private javax.swing.JTextArea ideTextArea;
    private javax.swing.JLabel technologieLabel;
    private javax.swing.JTextArea technologieTextArea;
    private javax.swing.JLabel versionLabel;
    private javax.swing.JTextArea versionTextArea;
    // End of variables declaration//GEN-END:variables
}
