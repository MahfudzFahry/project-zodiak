package tugas_2sc3;


import database.DBconnection;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import database.DBconnection;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import database.DBconnection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class SearchData extends javax.swing.JFrame {

    Connection connect;
    PreparedStatement pst;
    ResultSet rs;
    private DefaultTableModel tableModel;

    public SearchData() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        connect = new DBconnection().getConnection();
        this.setLocationRelativeTo(null);
    }
    editData edit = new editData();

    public class MyQuery {

        public Connection getConnection() {
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/shopee_db", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
            return con;
        }

        public ArrayList<Product2> BindTable() {

            ArrayList<Product2> list = new ArrayList<Product2>();
            Connection con = getConnection();
            Statement st;
            ResultSet rs;

            try {
                String cari = txtsearch.getText();
                st = con.createStatement();
                rs = st.executeQuery("Select * from search_data where nama_produk like '%" + cari + "%' order by nama_produk asc");

                Product2 p;
                while (rs.next()) {
                    p = new Product2(
                            rs.getString("id"),
                            rs.getString("bpom"),
                            rs.getString("nama_produk"),
                            rs.getString("status"),
                            rs.getBytes("gambar")
                    );
                    list.add(p);
                }

            } catch (SQLException ex) {
                Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
    }

    public void delete() {
        try {
            int p = JOptionPane.showConfirmDialog(null, "You must get permission from your Team Leader"
                    + "\nAre you sure deleted this ?", "Delete", JOptionPane.YES_NO_OPTION);
            if (p == 0) {
                int row = tableOutput.getSelectedRow();
                Object value = tableOutput.getModel().getValueAt(row, 0);
                String query = "DELETE FROM search_data where id = " + value;
                try {
                    pst = connect.prepareStatement(query);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "delete succesfully");
                    populateJTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Delete failed");
                } finally {
                    try {
                        pst.close();
                        rs.close();
                    } catch (Exception e) {
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Please select product");
            
        }
    }

    public void populateJTable() {
        MyQuery mq = new MyQuery();
        ArrayList<Product2> list = mq.BindTable();
        String[] columnName = {"No.", "BPOM / Prod.ID", "Product Name", "Status", "Image"};
        Object[][] rows = new Object[list.size()][6];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getId();
            rows[i][1] = list.get(i).getBpom();
            rows[i][2] = list.get(i).getNama_produk();
            rows[i][3] = list.get(i).getStatus();

            if (list.get(i).getGambar() != null) {

                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getGambar()).getImage()
                        .getScaledInstance(250, 250, Image.SCALE_SMOOTH));

                rows[i][4] = image;
            } else {
                rows[i][4] = null;
            }
        }

        TheModel model = new TheModel(rows, columnName);
        tableOutput.setModel(model);
        tableOutput.setRowHeight(150);
        tableOutput.getColumnModel().getColumn(3).setPreferredWidth(150);
    }

    public void lblreason() {
        int i = tableOutput.getSelectedRow();
        if (tableOutput.getValueAt(i, 1).toString() != "NONE" && tableOutput.getValueAt(i, 3).toString() != "PASS") {
            lblreason.setText("Melanggar ketentuan Shopee");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOutput = new javax.swing.JTable();
        btnupdate = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblreason = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        layout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(860, 200, 320, 260);

        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
        });
        getContentPane().add(txtsearch);
        txtsearch.setBounds(180, 140, 440, 40);

        jScrollPane1.setForeground(new java.awt.Color(255, 69, 7));

        tableOutput.setFont(new java.awt.Font("STXihei", 1, 12)); // NOI18N
        tableOutput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "BPOM / Prod.ID", "Product Name", "Status", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOutput.setSelectionBackground(new java.awt.Color(247, 105, 10));
        tableOutput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOutputMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableOutput);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 190, 780, 490);

        btnupdate.setFont(new java.awt.Font("STXihei", 1, 14)); // NOI18N
        btnupdate.setText("Edit Data");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate);
        btnupdate.setBounds(860, 520, 320, 50);

        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_search_322497 (1).png"))); // NOI18N
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch);
        btnsearch.setBounds(630, 140, 50, 40);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_document_text_add_103511.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(920, 590, 60, 60);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_-_Trash-Can-_3844425.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(1060, 590, 60, 60);
        getContentPane().add(lblreason);
        lblreason.setBounds(860, 470, 320, 40);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logoshopee.png"))); // NOI18N
        getContentPane().add(logo);
        logo.setBounds(530, 20, 320, 80);

        layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wallpapershopee.jpg"))); // NOI18N
        layout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                layoutMouseClicked(evt);
            }
        });
        getContentPane().add(layout);
        layout.setBounds(10, 10, 1300, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void tableOutputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOutputMouseClicked
        int i = tableOutput.getSelectedRow();
        if (tableOutput.getValueAt(i, 4) != null) {
            ImageIcon image1 = (ImageIcon) tableOutput.getValueAt(i, 4);
            Image image2 = image1.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image3 = new ImageIcon(image2);
            jLabel1.setIcon(image3);
        } else {
            System.out.println("No Image");
        }
//        if (tableOutput.getValueAt(i, 1).toString() == "NONE" && tableOutput.getValueAt(i, 3).toString() != "PASS") {
//            lblreason.setText("Tidak mencantumkan nomor izin edar / Legalitas produk");
//        } else {
//            lblreason();


    }//GEN-LAST:event_tableOutputMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed

        try {
            int p = JOptionPane.showConfirmDialog(null, "You will change about data product"
                    + "\nAre you sure edit this data ?", "Edit", JOptionPane.YES_NO_OPTION);
            if (p == 0) {

                int index = tableOutput.getSelectedRow();
                TableModel model = tableOutput.getModel();
                String id = model.getValueAt(index, 0).toString();
                String bpom = model.getValueAt(index, 1).toString();
                String product_name = model.getValueAt(index, 2).toString();
                String status = model.getValueAt(index, 3).toString();

                int i = tableOutput.getSelectedRow();
                if (tableOutput.getValueAt(i, 4) != null) {
                    ImageIcon image1 = (ImageIcon) tableOutput.getValueAt(i, 4);
                    Image image2 = image1.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon image3 = new ImageIcon(image2);
                    edit.jlabeloutputgmbar.setIcon(image3);
                } else {
                    System.out.println("No Image");
                }

                edit.setVisible(true);
                this.dispose();
                edit.pack();
                edit.setLocationRelativeTo(null);
                edit.setExtendedState(JFrame.MAXIMIZED_BOTH);

                edit.txtid.setText(id);
                edit.txtBPOM.setText(bpom);
                edit.txtProduct.setText(product_name);
                edit.boxstatus.setSelectedItem(status);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please select product");
        }

    }//GEN-LAST:event_btnupdateActionPerformed

    private void layoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_layoutMouseClicked

    }//GEN-LAST:event_layoutMouseClicked

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        populateJTable();
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new InputItem().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            populateJTable();
        }
    }//GEN-LAST:event_txtsearchKeyPressed
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
            java.util.logging.Logger.getLogger(SearchData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel layout;
    private javax.swing.JLabel lblreason;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tableOutput;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
