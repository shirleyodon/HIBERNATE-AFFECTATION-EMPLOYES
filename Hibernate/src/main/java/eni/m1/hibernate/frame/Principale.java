package eni.m1.hibernate.frame;

import eni.m1.hibernate.dialog.AboutProject;
import eni.m1.hibernate.dialog.Authentification;
import eni.m1.hibernate.dialog.Developper;
import eni.m1.hibernate.panels.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shirleyodon
 */
public class Principale extends javax.swing.JFrame {

    /**
     * Creates new form Principale
     */
    public Principale() {
        initComponents();
        initTabbedPane();
        setLocationRelativeTo(null);
    }
    
    private String setTabGap(String name, int gap){
        String space="";
        for(int i=0; i<gap; i++)
            space+=" ";
        return space+name+space;
    }
    
    private void initTabbedPane(){
        List<JPanel> listPanel=new ArrayList<>();
        listPanel.add(new EmployePanel());
        listPanel.add(new LieuPanel());
        listPanel.add(new AffectationPanel());
        
        String nomOnglet[]={"Employés", "Lieux", "Affectations"};
        for(int i=0; i<listPanel.size(); i++)
            onglets.add(setTabGap(nomOnglet[i], 16), listPanel.get(i));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        onglets = new javax.swing.JTabbedPane();
        menuBar = new javax.swing.JMenuBar();
        menuFichier = new javax.swing.JMenu();
        logoutItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        menuPlusInfo = new javax.swing.JMenu();
        aboutProjectItem = new javax.swing.JMenuItem();
        madeByItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRINCIPALE");
        setPreferredSize(new java.awt.Dimension(785, 615));
        setSize(new java.awt.Dimension(850, 650));

        onglets.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        menuBar.setForeground(new java.awt.Color(236, 240, 241));
        menuBar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuBar.setPreferredSize(new java.awt.Dimension(97, 30));

        menuFichier.setBackground(new java.awt.Color(245, 103, 27));
        menuFichier.setForeground(new java.awt.Color(255, 255, 255));
        menuFichier.setText("Fichier");
        menuFichier.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        menuFichier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuFichier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuFichier.setIconTextGap(10);
        menuFichier.setOpaque(true);

        logoutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK));
        logoutItem.setBackground(new java.awt.Color(33, 47, 61));
        logoutItem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        logoutItem.setForeground(new java.awt.Color(236, 240, 241));
        logoutItem.setText("Déconnexion");
        logoutItem.setOpaque(true);
        logoutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutItemActionPerformed(evt);
            }
        });
        menuFichier.add(logoutItem);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exitItem.setBackground(new java.awt.Color(33, 47, 61));
        exitItem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        exitItem.setForeground(new java.awt.Color(236, 240, 241));
        exitItem.setText("Quitter");
        exitItem.setOpaque(true);
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        menuFichier.add(exitItem);

        menuBar.add(menuFichier);

        menuPlusInfo.setBackground(new java.awt.Color(245, 103, 27));
        menuPlusInfo.setForeground(new java.awt.Color(255, 255, 255));
        menuPlusInfo.setText("   ?");
        menuPlusInfo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        menuPlusInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuPlusInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuPlusInfo.setIconTextGap(10);
        menuPlusInfo.setOpaque(true);
        menuPlusInfo.setPreferredSize(new java.awt.Dimension(40, 21));

        aboutProjectItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
        aboutProjectItem.setBackground(new java.awt.Color(33, 47, 61));
        aboutProjectItem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        aboutProjectItem.setForeground(new java.awt.Color(236, 240, 241));
        aboutProjectItem.setText("A propos");
        aboutProjectItem.setOpaque(true);
        aboutProjectItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutProjectItemActionPerformed(evt);
            }
        });
        menuPlusInfo.add(aboutProjectItem);

        madeByItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_DOWN_MASK));
        madeByItem.setBackground(new java.awt.Color(33, 47, 61));
        madeByItem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        madeByItem.setForeground(new java.awt.Color(236, 240, 241));
        madeByItem.setText("Développeuse");
        madeByItem.setOpaque(true);
        madeByItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                madeByItemActionPerformed(evt);
            }
        });
        menuPlusInfo.add(madeByItem);

        menuBar.add(menuPlusInfo);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(onglets, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(onglets, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutItemActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment vous déconnecter ?", "Confirmation de déconnexion",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
            Authentification dialog = new Authentification(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_logoutItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir quitter l'application ?", "Confirmation de fermeture",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_exitItemActionPerformed

    private void aboutProjectItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutProjectItemActionPerformed
        // TODO add your handling code here:
        AboutProject aboutProject=new AboutProject(null, true);
        aboutProject.setVisible(true);
    }//GEN-LAST:event_aboutProjectItemActionPerformed

    private void madeByItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_madeByItemActionPerformed
        // TODO add your handling code here:
        Developper dialog = new Developper(null, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_madeByItemActionPerformed

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
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutProjectItem;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenuItem logoutItem;
    private javax.swing.JMenuItem madeByItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFichier;
    private javax.swing.JMenu menuPlusInfo;
    private javax.swing.JTabbedPane onglets;
    // End of variables declaration//GEN-END:variables
}
