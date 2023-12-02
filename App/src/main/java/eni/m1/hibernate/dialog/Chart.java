/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eni.m1.hibernate.dialog;

import com.toedter.calendar.JDateChooser;
import eni.m1.hibernate.dao.AffectationDAO;
import eni.m1.hibernate.entities.Affectation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author shirleyodon
 */
public class Chart extends javax.swing.JDialog {

    /**
     * Creates new form Chart
     */
    private JFreeChart chart;
    private ChartPanel chartPanel;
    private final Dimension chartPanelDimension=new Dimension(485, 425);
    private final SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
    private final AffectationDAO dao=new AffectationDAO();
    
    public Chart(java.awt.Frame parent, boolean modal, List<Object> list) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        if(list!=null) createPieChart(repartirDonnees(list), null, null);
        else{
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de la récupération des données !", "Données NULL", JOptionPane.ERROR_MESSAGE);
            createPieChart(repartirDonnees(new ArrayList()), null, null);
        }
        initChartPanel();
        initGraphPanel();
    }
    
    private HashMap<String, Integer> repartirDonnees(List<Object> list){
        HashMap<String, Integer> data=new HashMap();
        for(Object a: list){
            String key=((Affectation)a).getLieu().getProvince().toUpperCase();
            if(data.containsKey(key)){
                int oldValue=data.get(key);
                data.replace(key, oldValue, oldValue+1);
            }else data.put(key, 1);
        }
        return data;
    }
    
    private void createPieChart(HashMap<String, Integer> data, Date start, Date end){
        DefaultPieDataset dataset=new DefaultPieDataset();
        Set<String> keys= data.keySet();
        Iterator<String> it=keys.iterator();
        while(it.hasNext()){
            String key=it.next();
            dataset.setValue(key, data.get(key));
        }
        
        chart=ChartFactory.createPieChart("", dataset, true, true, false);
        
        /*  Titre   */
        String titre="Répartition des employés selon leurs lieux d'affectation";
        if(start!=null && end!=null){
            try{
                titre+="\nEntre les dates "+format.format(start)+" et "+format.format(end);
            }catch(Exception ex){
                System.err.println("\nErreur causée par createPieChart() de ChartDialog !\n"+ex);
            }
        }
        TextTitle title=new TextTitle(titre, new Font ("Trebuchet MS", Font.BOLD , 18));
        chart.setTitle(title);
        chart.getTitle().setPaint(new Color(33,47,61));
        
        PiePlot plot=(PiePlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 255, 255, 0));
    }
    
    private void initChartPanel(){
        chartPanel=new ChartPanel(chart);
        chartPanel.setPreferredSize(chartPanelDimension);
    }
    
    private void initGraphPanel(){
        graphPanel.setLayout(new BorderLayout());
        graphPanel.add(chartPanel, BorderLayout.CENTER);
        graphPanel.validate();
    }
    
    private String toChaine(Integer d){
        return (d<10)? "0"+d.toString(): d.toString();
    }
    
    private String obtenirHeure(Calendar cal){
        String h=toChaine(cal.get(Calendar.HOUR_OF_DAY)),
               m=toChaine(cal.get(Calendar.MINUTE)),
               s=toChaine(cal.get(Calendar.SECOND));
        return h+m+s;
    }
    
    private String obtenirDate(Calendar cal){
        String dd=toChaine(cal.get(Calendar.DAY_OF_MONTH)),
               mm=toChaine(cal.get(Calendar.MONTH)+1),
               yy=toChaine(cal.get(Calendar.YEAR));
        return dd+mm+yy;
    }
    
    private String nomFichier(Calendar cal){
        return "PieChart"+"_"+obtenirDate(cal)+obtenirHeure(cal)+".jpeg";
    }
    
    private boolean estValide(JDateChooser d){
        return (d.getDate()!=null);
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
        datePanel = new javax.swing.JPanel();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        endDateChooser = new com.toedter.calendar.JDateChooser();
        okButton = new javax.swing.JButton();
        graphPanel = new javax.swing.JPanel();
        saveImageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GRAPHE");

        bodyPanel.setBackground(new java.awt.Color(33, 47, 61));

        datePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Intervalles de dates", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Trebuchet MS", 1, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        datePanel.setOpaque(false);

        startDateLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        startDateLabel.setForeground(new java.awt.Color(236, 240, 241));
        startDateLabel.setText("Début");

        endDateLabel.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        endDateLabel.setForeground(new java.awt.Color(236, 240, 241));
        endDateLabel.setText("Fin");

        startDateChooser.setDateFormatString("d MMM yyyy");
        startDateChooser.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        startDateChooser.setPreferredSize(new java.awt.Dimension(148, 26));

        endDateChooser.setDateFormatString("d MMM yyyy");
        endDateChooser.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        endDateChooser.setPreferredSize(new java.awt.Dimension(148, 26));

        okButton.setBackground(new java.awt.Color(86, 101, 115));
        okButton.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        okButton.setForeground(new java.awt.Color(255, 255, 255));
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datePanelLayout = new javax.swing.GroupLayout(datePanel);
        datePanel.setLayout(datePanelLayout);
        datePanelLayout.setHorizontalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(startDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(endDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
        );
        datePanelLayout.setVerticalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(okButton)
                    .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateLabel)
                    .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateLabel))
                .addGap(14, 14, 14))
        );

        graphPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Trebuchet MS", 1, 22), new java.awt.Color(255, 255, 255))); // NOI18N
        graphPanel.setOpaque(false);
        graphPanel.setPreferredSize(new java.awt.Dimension(503, 443));

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        saveImageButton.setBackground(new java.awt.Color(86, 101, 115));
        saveImageButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        saveImageButton.setForeground(new java.awt.Color(255, 250, 250));
        saveImageButton.setText("Sauvegarder l'image");
        saveImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(datePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveImageButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        if(estValide(startDateChooser)){
            if(estValide(endDateChooser)){
                List list=dao.listerAffectationParIntervalleDate(startDateChooser.getDate(), endDateChooser.getDate());
                try{
                    if(list!=null){
                        if(list.isEmpty()) JOptionPane.showMessageDialog(null, "Aucune affectation entre les dates "+format.format(startDateChooser.getDate())+ " et "+ format.format(endDateChooser.getDate())+ " n'a été trouvée !", "Aucun resultat", JOptionPane.INFORMATION_MESSAGE);
                        createPieChart(repartirDonnees(list), startDateChooser.getDate(), endDateChooser.getDate());
                        initChartPanel();
                        graphPanel.removeAll();
                        initGraphPanel(); 
                    }else JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de la récupération des données !", "Données NULL", JOptionPane.ERROR_MESSAGE);
                }catch(Exception ex){
                    System.err.println("\nErreur causée par okButtonActionPerformed() de ChartDialog !\n"+ex);
                }
            }else JOptionPane.showMessageDialog(null, "La date de Fin est invalide !", "Date invalide", JOptionPane.WARNING_MESSAGE);
        }else JOptionPane.showMessageDialog(null, "La date de Début est invalide !", "Date invalide", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_okButtonActionPerformed

    private void saveImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImageButtonActionPerformed
        // TODO add your handling code here:
        String fileName=nomFichier(Calendar.getInstance());   
        String path="C:\\Users\\26134\\Documents\\NetBeansProjects\\Hibernate2\\chart\\";
        File file=new File(path+fileName);
        String message="L'image a été sauvegardée sous le :\n"
                        + "\tNom : "+fileName+"\n"
                        + "\tRépertoire : "+path;
        try{
            ChartUtils.saveChartAsJPEG(file, chart, 503, 443);
            JOptionPane.showMessageDialog(null, message, "Succès de la sauvegarde", JOptionPane.INFORMATION_MESSAGE);
        }catch(IOException ex){
            Logger.getLogger(Dialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveImageButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AffectationDAO dao2=new AffectationDAO();
                Chart dialog = new Chart(new javax.swing.JFrame(), true, dao2.listerAffectation());
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
    private javax.swing.JPanel datePanel;
    private com.toedter.calendar.JDateChooser endDateChooser;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JButton saveImageButton;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private javax.swing.JLabel startDateLabel;
    // End of variables declaration//GEN-END:variables
}
