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
public class Developper extends javax.swing.JDialog {

    /**
     * Creates new form Developper
     */
    public Developper(java.awt.Frame parent, boolean modal) {
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
        infoPanel = new javax.swing.JPanel();
        nomLabel = new javax.swing.JLabel();
        nomField = new javax.swing.JTextField();
        prenomLabel = new javax.swing.JLabel();
        prenomField = new javax.swing.JTextField();
        matriculeLabel = new javax.swing.JLabel();
        matriculeField = new javax.swing.JTextField();
        telLabel = new javax.swing.JLabel();
        telField = new javax.swing.JTextField();
        photoPanel = new javax.swing.JPanel();
        photoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEVELOPPEUSE");

        bodyPanel.setBackground(new java.awt.Color(33, 47, 61));

        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Trebuchet MS", 1, 22), new java.awt.Color(236, 240, 241))); // NOI18N
        infoPanel.setOpaque(false);

        nomLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        nomLabel.setForeground(new java.awt.Color(236, 240, 241));
        nomLabel.setText("Nom");

        nomField.setEditable(false);
        nomField.setBackground(new java.awt.Color(86, 101, 115));
        nomField.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        nomField.setForeground(new java.awt.Color(255, 250, 250));
        nomField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomField.setText("RENNÉE");

        prenomLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        prenomLabel.setForeground(new java.awt.Color(236, 240, 241));
        prenomLabel.setText("Prénoms");

        prenomField.setEditable(false);
        prenomField.setBackground(new java.awt.Color(86, 101, 115));
        prenomField.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        prenomField.setForeground(new java.awt.Color(255, 250, 250));
        prenomField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prenomField.setText("Vavy Fleurisse");

        matriculeLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        matriculeLabel.setForeground(new java.awt.Color(236, 240, 241));
        matriculeLabel.setText("N° matricule");

        matriculeField.setEditable(false);
        matriculeField.setBackground(new java.awt.Color(86, 101, 115));
        matriculeField.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        matriculeField.setForeground(new java.awt.Color(255, 250, 250));
        matriculeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        matriculeField.setText("2045");

        telLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        telLabel.setForeground(new java.awt.Color(236, 240, 241));
        telLabel.setText("Tel");

        telField.setEditable(false);
        telField.setBackground(new java.awt.Color(86, 101, 115));
        telField.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        telField.setForeground(new java.awt.Color(255, 250, 250));
        telField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telField.setText("034 95 717 42");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(matriculeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prenomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(telLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomField)
                    .addComponent(prenomField, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(matriculeField)
                    .addComponent(telField))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomLabel)
                    .addComponent(nomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenomLabel))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matriculeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matriculeLabel))
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        photoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Photo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Trebuchet MS", 1, 22), new java.awt.Color(236, 240, 241))); // NOI18N
        photoPanel.setOpaque(false);
        photoPanel.setLayout(new java.awt.BorderLayout());

        photoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photoLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\26134\\Documents\\NetBeansProjects\\Hibernate2\\icon\\Fleu3.png")); // NOI18N
        photoLabel.setDoubleBuffered(true);
        photoPanel.add(photoLabel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(photoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Developper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Developper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Developper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Developper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Developper dialog = new Developper(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel infoPanel;
    private javax.swing.JTextField matriculeField;
    private javax.swing.JLabel matriculeLabel;
    private javax.swing.JTextField nomField;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JPanel photoPanel;
    private javax.swing.JTextField prenomField;
    private javax.swing.JLabel prenomLabel;
    private javax.swing.JTextField telField;
    private javax.swing.JLabel telLabel;
    // End of variables declaration//GEN-END:variables
}
