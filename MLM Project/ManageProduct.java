

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.logging.*;

/**
 *
 * @author Kaushal Vasava
 */

public class ManageProduct extends JFrame {
     
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    public static JTable jTable1;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;
    private JTextField jTextField9; 
    
    Product pro = new Product();
   
    public ManageProduct() {
        initComponents();
        pro.fillProduct(jTable1, "");
        jTable1.setRowHeight(40);
    }

    private void initComponents() {

        jPanel2 = new JPanel();
        jLabel5 = new JLabel();
        jLabel7 = new JLabel();
        jTextField5 = new JTextField();
        jLabel8 = new JLabel();
        jTextField6 = new JTextField();
        jLabel9 = new JLabel();
        jTextField7 = new JTextField();
        jLabel10 = new JLabel();
        jTextField8 = new JTextField();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jTextField9 = new JTextField();
        jLabel11 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 650));

        jPanel2.setLayout(null);

        jLabel5.setFont(new Font("Tahoma", 1, 24));
        jLabel5.setText("Manage Product");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(332, 52, 225, 29);

        jLabel7.setFont(new Font("Tahoma", 0, 18)); 
        jLabel7.setText("Search:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(470, 130, 90, 22);

        jTextField5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField5);
        jTextField5.setBounds(170, 140, 211, 30);

        jLabel8.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Product Name:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(45, 209, 117, 22);

        jTextField6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField6);
        jTextField6.setBounds(174, 211, 211, 30);

        jLabel9.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Price:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(119, 366, 43, 22);

        jTextField7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField7);
        jTextField7.setBounds(174, 284, 211, 30);

        jLabel10.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Total Qty.:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(77, 282, 85, 22);

        jTextField8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField8);
        jTextField8.setBounds(174, 366, 211, 30);

        jButton3.setFont(new Font("Tahoma", 0, 16)); 
        jButton3.setText("Remove");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(73, 513, 89, 29);

        jButton4.setFont(new Font("Tahoma", 0, 16)); 
        jButton4.setText("Update");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(184, 513, 100, 29);

        jButton5.setFont(new Font("Tahoma", 0, 16));
        jButton5.setText("Add");
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(308, 513, 61, 29);

        jTable1.setFont(new Font("Tahoma", 0, 15));
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "P_ID", "Product Name", "Total Qty.", "Price"
            }
        ));
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(470, 173, 481, 296);

        jTextField9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
            public void keyTyped(KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField9);
        jTextField9.setBounds(530, 130, 211, 30);

        jLabel11.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Product ID:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(62, 139, 100, 22);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1002, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void jTextField5ActionPerformed(ActionEvent evt) {

    }
    private void jTextField5KeyTyped(KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyC0har())) {
            evt.consume();
        }
    }

    private void jTextField6ActionPerformed(ActionEvent evt) {
        
    }

    private void jTextField7KeyTyped(KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }
    private void jTextField8KeyTyped(KeyEvent evt) {
    
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        try {
            String pid = jTextField5.getText();

            Product p1 = new Product();
            p1.addProduct('d', pid, null, null, null);

            ManageProduct.jTable1.setModel(new DefaultTableModel(null, new Object[]{"P_ID", "PNAME", "Total Qty", "Price"}));
            pro.fillProduct(ManageProduct.jTable1, "");

            jTextField5.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            jTextField8.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Price!!!");
        }
    }

    public boolean verifyText() {
        if (jTextField5.getText().equals("") || jTextField6.getText().equals("") || jTextField7.getText().equals("") || jTextField8.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Field");
            return false;
        }

        if (Integer.parseInt(jTextField7.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Total Quantity not allowed");
            return false;
        }
        if (Float.parseFloat(jTextField8.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Price not allowed");
            return false;
        }
        return true;
    }
    private void jButton4ActionPerformed(ActionEvent evt) {
        try {
            String pid = jTextField5.getText();
            String pname = jTextField6.getText();
            String total = jTextField7.getText();
            String price = jTextField8.getText();

            if (verifyText()) {
                Product p1 = new Product();
                p1.addProduct('u', pid, pname, total, price);

                ManageProduct.jTable1.setModel(new DefaultTableModel(null, new Object[]{"P_ID", "PNAME", "Total Qty", "Price"}));
                pro.fillProduct(ManageProduct.jTable1, "");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Price!!!");
        }

    }
    private void jButton5ActionPerformed(ActionEvent evt) {
        try{
            String pid=jTextField5.getText();
        String pname=jTextField6.getText();
        String total=jTextField7.getText();
        String price=jTextField8.getText();
        
            if(verifyText()){
                Product p1=new Product();
                p1.addProduct('i',pid,pname,total,price);
                
                ManageProduct.jTable1.setModel(new DefaultTableModel(null,new Object[]{"P_ID","PNAME","Total Qty","Price"}));
                pro.fillProduct(ManageProduct.jTable1,"");
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Price!!!");
        }
    }

    private void jTable1MouseClicked(MouseEvent evt) {
        int rowIndex = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        jTextField5.setText(model.getValueAt(rowIndex, 0).toString());
        jTextField6.setText(model.getValueAt(rowIndex, 1).toString());
        jTextField7.setText(model.getValueAt(rowIndex, 2).toString());
        jTextField8.setText(model.getValueAt(rowIndex, 3).toString());
    }

    private void jTextField9ActionPerformed(ActionEvent evt){
     
    }
    private void jTextField9KeyTyped(KeyEvent evt) {
    
    }

    private void jTextField9KeyReleased(KeyEvent evt) {
        jTable1.setModel(new DefaultTableModel(null, new Object[]{"P_ID", "PNAME", "Total Qty", "Price"}));
        pro.fillProduct(jTable1, jTextField9.getText());
    }

    private void jTextField7ActionPerformed(ActionEvent evt) {
       
    }
    private void jTextField8ActionPerformed(ActionEvent evt) {
     
    }
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ManageProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ManageProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ManageProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageProduct().setVisible(true);
            }
        });
    }
}
