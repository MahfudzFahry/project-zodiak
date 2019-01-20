package tugas_2sc3;


import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class editData extends javax.swing.JFrame {

    Connection connect;
    Statement stmt;
    ResultSet rs;
    String s;
    String idUpdate;
    int flag;

    public editData() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        idUpdate = txtid.getText();
        txtid.setEditable(false);
    }

    public void choose() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jlabeloutputgmbar.setIcon(ResizeImage(path));
            s = path;
            flag = 1;
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Data");
        }
    }

    private void update() {
        String id = txtid.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/shopee_db", "root", "");
            String query = "UPDATE search_data SET bpom=?, nama_produk=?, status=? WHERE id ='" + id + "'";
            PreparedStatement ps = con.prepareStatement(query);

//            InputStream is = new FileInputStream(new File(s));
            ps.setString(1, txtBPOM.getText());
            ps.setString(2, txtProduct.getText());
            ps.setString(3, boxstatus.getSelectedItem().toString());
            int data = ps.executeUpdate();
            if (data != 0) {
                JOptionPane.showMessageDialog(this, "Data Updated....");
                txtBPOM.setText("");
                txtProduct.setText("");
                jlabeloutputgmbar.setIcon(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    private void update2() {
        String id = txtid.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/shopee_db", "root", "");
            String query = "UPDATE search_data SET bpom=?, nama_produk=?, status=?, gambar=? WHERE id ='" + id + "'";
            PreparedStatement ps = con.prepareStatement(query);

            InputStream is = new FileInputStream(new File(s));
            ps.setString(1, txtBPOM.getText());
            ps.setString(2, txtProduct.getText());
            ps.setString(3, boxstatus.getSelectedItem().toString());
            ps.setBlob(4, is);
            int data = ps.executeUpdate();
            if (data != 0) {
                JOptionPane.showMessageDialog(this, "Data Updated....");
                txtBPOM.setText("");
                txtProduct.setText("");
                jlabeloutputgmbar.setIcon(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBPOM = new javax.swing.JTextField();
        txtProduct = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        choosefile = new javax.swing.JButton();
        boxstatus = new javax.swing.JComboBox();
        jlabeloutputgmbar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnundo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtBPOM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBPOMActionPerformed(evt);
            }
        });
        getContentPane().add(txtBPOM);
        txtBPOM.setBounds(40, 190, 440, 40);
        getContentPane().add(txtProduct);
        txtProduct.setBounds(40, 290, 440, 40);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave);
        btnSave.setBounds(50, 480, 310, 40);

        choosefile.setText("Choose file");
        choosefile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosefileActionPerformed(evt);
            }
        });
        getContentPane().add(choosefile);
        choosefile.setBounds(680, 150, 130, 40);

        boxstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PASS", "DELETED" }));
        getContentPane().add(boxstatus);
        boxstatus.setBounds(40, 400, 450, 40);

        jlabeloutputgmbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/square-frame (6).png"))); // NOI18N
        getContentPane().add(jlabeloutputgmbar);
        jlabeloutputgmbar.setBounds(620, 200, 290, 280);

        jLabel6.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_32_171485.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(730, 320, 40, 30);

        jLabel4.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel4.setText("STATUS");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 370, 140, 20);

        jLabel2.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel2.setText("PRODUCT NAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 260, 140, 20);

        jLabel5.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        jLabel5.setText("BPOM CODE");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 160, 140, 20);

        btnBack.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_ic_home_48px_352427 (1).png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(440, 480, 40, 40);

        btnundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_undo_308948 (1).png"))); // NOI18N
        btnundo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnundoActionPerformed(evt);
            }
        });
        getContentPane().add(btnundo);
        btnundo.setBounds(860, 480, 40, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_pencil_216350.png"))); // NOI18N
        jLabel7.setText(" ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1000, 0, 50, 60);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logoshopee.png"))); // NOI18N
        getContentPane().add(logo);
        logo.setBounds(320, 20, 320, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wallpapershopee.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1060, 640);

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        getContentPane().add(txtid);
        txtid.setBounds(400, 250, 10, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBPOMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBPOMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBPOMActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (flag == 1) {
            update2();
        } else {
            update();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void choosefileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosefileActionPerformed
        choose();
    }//GEN-LAST:event_choosefileActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new SearchData().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void btnundoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnundoActionPerformed
        jlabeloutputgmbar.setIcon(null);
    }//GEN-LAST:event_btnundoActionPerformed

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
            java.util.logging.Logger.getLogger(editData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox boxstatus;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnundo;
    private javax.swing.JButton choosefile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jlabeloutputgmbar;
    private javax.swing.JLabel logo;
    public javax.swing.JTextField txtBPOM;
    public javax.swing.JTextField txtProduct;
    public javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
public ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(jlabeloutputgmbar.getWidth(), jlabeloutputgmbar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
}
