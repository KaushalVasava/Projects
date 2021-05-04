
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Kaushal Vasava
 */

public class AddProduct extends JFrame {
    
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    
    Product pro=new Product();
    public AddProduct() {
        initComponents();
    }
    
    private void initComponents() {

        jLabel5 = new JLabel();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jLabel4 = new JLabel();
        jTextField3 = new JTextField();
        jLabel6 = new JLabel();
        jTextField4 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();

        jLabel5.setFont(new Font("Tahoma", 0, 18)); 
        jLabel5.setText("Total Qty.:");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(501, 630));

        jPanel1.setLayout(null);

        jLabel1.setFont(new Font("Tahoma", 1, 24)); 
        jLabel1.setText("Add Product");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(160, 44, 162, 29);

        jLabel2.setFont(new Font("Tahoma", 0, 18)); 
        jLabel2.setText("Product ID:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(62, 139, 100, 22);

        jTextField1.setFont(new Font("Tahoma", 0, 16)); 
        jTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(174, 141, 211, 26);

        jLabel3.setFont(new Font("Tahoma", 0, 18)); 
        jLabel3.setText("Product Name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(45, 211, 117, 22);

        jTextField2.setFont(new Font("Tahoma", 0, 16)); 
        jTextField2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(174, 213, 211, 26);

        jLabel4.setFont(new Font("Tahoma", 0, 18)); 
        jLabel4.setText("Price:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(119, 368, 43, 22);

        jTextField3.setFont(new Font("Tahoma", 0, 16)); 
        jTextField3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(174, 286, 211, 26);

        jLabel6.setFont(new Font("Tahoma", 0, 18)); 
        jLabel6.setText("Total Qty.:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(77, 284, 85, 22);

        jTextField4.setFont(new Font("Tahoma", 0, 16)); 
        jTextField4.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(174, 368, 211, 26);

        jButton1.setFont(new Font("Tahoma", 0, 16)); 
        jButton1.setText("Cancel");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(83, 495, 79, 29);

        jButton2.setFont(new Font("Tahoma", 0, 16)); 
        jButton2.setText("Add");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(341, 495, 61, 29);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );

        pack();
    }
    private void jTextField1ActionPerformed(ActionEvent evt) {
    }

    private void jTextField2ActionPerformed(ActionEvent evt) {
     
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void jTextField1KeyTyped(KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar()))
        {
        evt.consume();}
    }

    private void jTextField3KeyTyped(KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar()))
        {
        evt.consume();}
    }

    public boolean verifyText(){
        if(jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("") || jTextField4.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Empty Field");
            return false;
        }
          
        if(Integer.parseInt(jTextField3.getText())<=0)
        {
            JOptionPane.showMessageDialog(null,"Total Quantity not allowed");
            return false;
        }
        if(Float.parseFloat(jTextField4.getText())<=0)
        {
            JOptionPane.showMessageDialog(null,"Price not allowed");
            return false;
        }
        return true;
    }
    
    private void jButton2ActionPerformed(ActionEvent evt) {
        try{
            String pid=jTextField1.getText();
        String pname=jTextField2.getText();
        String total=jTextField3.getText();
        String price=jTextField4.getText();
        
            if(verifyText()){
                Product p1=new Product();
                p1.addProduct('i',pid,pname,total,price);
                
                // Update Record in Table entry
                ManageProduct.jTable1.setModel(new DefaultTableModel(null,new Object[]{"P_ID","PNAME","Total Qty","Price"}));
                pro.fillProduct(ManageProduct.jTable1,"");
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Price!!!");
        }
        
    }

    private void jTextField4KeyTyped(KeyEvent evt) {

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
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
