/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1.compi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author iova
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane2.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jButton1.setText("GENERAR AUTOMATA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ANALIZAR ENTRADAS");

        jButton3.setText("ANTERIOR");

        jButton4.setText("SIGUIENTE");

        jMenu1.setText("ARCHIVO");

        jMenu2.setText("ABRIR");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu2);

        jMenu3.setText("GUARDAR");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu3);

        jMenu5.setText("GUARDAR COMO");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu5);

        jMenu6.setText("GENERAR XML DE SALIDA");
        jMenu1.add(jMenu6);

        jMenuBar1.add(jMenu1);

        jMenu7.setText("COMPILADOR");

        jMenu8.setText("TABLA DE SIMBOLOS");
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });
        jMenu7.add(jMenu8);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(87, 87, 87)
                .addComponent(jButton2)
                .addGap(193, 193, 193)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static ArrayList<Token> lis_toks;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Analizador_Lexico a_lexico = new Analizador_Lexico();        
        String texto;
        lis_toks = new ArrayList<Token>();
        lis_toks = a_lexico.getListaTokens();
        texto = jTextArea1.getText().toLowerCase();
        a_lexico.escaner(texto);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        // TODO add your handling code here:
        tabla_simbolos();
        Obteniendo_Tokens hi = new Obteniendo_Tokens();
        hi.recorrer();
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        AbrirArchi();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        guardar_como();
    }//GEN-LAST:event_jMenu5MouseClicked

    
    public String escribir = "";
    Reader leer;
    public static String raiz;
    public String AbrirArchi()
    {
        String auxiliar = "";
        String texto = "";        
        try{
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);
            File abrir = file.getSelectedFile();
            System.out.println("esto es selectedfile: "+abrir);
            String nombre = abrir.getName();
            String ruta = abrir.getPath();
            String remplazar_ruta = ruta.replace("C:\\Users\\iovan\\Dropbox\\COMPI1\\", "");
            String remplazar_ruta1 = remplazar_ruta.replace("\\", "%");
            String[] obtener_raiz = remplazar_ruta1.split("%");
            raiz = obtener_raiz[0];
            
            if(abrir!=null){
                if(jTextArea1.getText().equals("")){
                    FileReader archivos=new FileReader(abrir);
                    BufferedReader lee=new BufferedReader(archivos);
                    while((auxiliar=lee.readLine())!=null){
                        texto+= auxiliar+ "\n";
                        jTextArea1.setText(texto);
                        escribir=texto;
                        leer = new StringReader(escribir);
                        escribir=texto;
                    }
                    lee.close(); 
                }
            }
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,ex+"" +
           "\nNo se ha encontrado el archivo",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }
    
    
    public File archivi;
    public String texto = "";
    public void guardar_como(){
        JFileChooser guardar = new JFileChooser();
        guardar.showSaveDialog(this);
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File archivo = guardar.getSelectedFile();
        archivi = guardar.getSelectedFile();
        File ruta = guardar.getCurrentDirectory();
        String nombre = guardar.getSelectedFile().getName();
        if(jTextArea1.getText()!=""){
            guardarFichero(jTextArea1.getText(), archivo);
        }
        
    }
    
    public void guardar(){
        if(jTextArea1.getText()!=""){
            guardarFichero(jTextArea1.getText(), archivi);
        }
    }
    
    public void guardarFichero(String cadena, File archivo){
        FileWriter escribir;
        try {
            escribir = new FileWriter(archivo, true);
            escribir.write(cadena);
            escribir.close();
        } catch (FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
        } catch (IOException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
        }
    }
    
    
    public static void tabla_simbolos()
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Lexema");
        model.addColumn("Token");
        model.addColumn("Tipo");
        model.addColumn("Linea");
        model.addColumn("Columna");
        
        for(int i = 0; i < lis_toks.size(); i++) 
        {
            Token actual = lis_toks.get(i);
            String no = String.valueOf(i+1);
            model.addRow(new Object[]{no,actual.getLexema(),actual.getIdToken(),actual.getTipo(),actual.getLinea(),actual.getColumna()});
        }
        TABLA_DE_SIMBOLOS jt = new TABLA_DE_SIMBOLOS();
        TABLA_DE_SIMBOLOS.jTable1.setModel(model);
        jt.show();
    }
    
        
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}