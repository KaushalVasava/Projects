

import javax.swing.*;
import javax.swing.table.*;
import java.util.logging.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Kaushal Vasava
 */

public class AddCustomer extends JFrame {
    
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    
    public AddCustomer() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADD Customer");
        setPreferredSize(new Dimension(565, 785));

        jPanel1.setLayout(null);

        jLabel1.setFont(new Font("Tahoma", 1, 24)); 
        jLabel1.setText("Add Customer");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(210, 70, 172, 29);

        jLabel2.setFont(new Font("Tahoma", 0, 18)); 
        jLabel2.setText("Customer Name:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(36, 305, 132, 22);

        jLabel3.setFont(new Font("Tahoma", 0, 18)); 
        jLabel3.setText("Customer ID:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(67, 179, 106, 22);

        jLabel4.setFont(new Font("Tahoma", 0, 18));
        jLabel4.setText("Balance:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(102, 376, 66, 22);

        jLabel5.setFont(new Font("Tahoma", 0, 18));
        jLabel5.setText("Phone No.:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 450, 88, 22);

        jLabel6.setFont(new Font("Tahoma", 0, 18));
        jLabel6.setText("Address:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(99, 521, 77, 22);

        jLabel7.setFont(new Font("Tahoma", 0, 18)); 
        jLabel7.setText("Sponser ID:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(74, 242, 94, 22);

        jTextField1.setFont(new Font("Tahoma", 0, 16)); 
        jTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(247, 234, 90, 30);

        jTextField2.setFont(new Font("Tahoma", 0, 16));
        jTextField2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(247, 178, 90, 30);

        jTextField3.setFont(new Font("Tahoma", 0, 16)); 
        jTextField3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(247, 303, 250, 30);

        jTextField4.setFont(new Font("Tahoma", 0, 16)); 
        jTextField4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(247, 448, 250, 30);

        jTextField5.setFont(new Font("Tahoma", 0, 16));
        jTextField5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField5);
        jTextField5.setBounds(247, 374, 250, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new Font("Monospaced", 0, 16)); 
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(247, 521, 250, 116);

        jButton1.setFont(new Font("Tahoma", 0, 15)); 
        jButton1.setText("Add");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(370, 680, 68, 35);

        jButton2.setFont(new Font("Tahoma", 0, 15)); 
        jButton2.setText("Cancel");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(120, 680, 90, 35);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE))
        );

        pack();
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
    
    }

    private void jTextField2ActionPerformed(ActionEvent evt) {
    
    }
    private void jTextField3ActionPerformed(ActionEvent evt) {
    
    }

    private void jTextField4ActionPerformed(ActionEvent evt) {
    
    }
    private void jTextField5ActionPerformed(ActionEvent evt) {
    
    }
    
    private void jButton2ActionPerformed(ActionEvent evt) {
        this.dispose();
    }

       public boolean verifyText(){
        if(jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("") || 
                jTextField4.getText().equals("") || jTextField5.getText().equals(""))
        {
           JOptionPane.showMessageDialog(null,"Empty Field");
            return false;
        }
          
        if(Integer.parseInt(jTextField5.getText())<=0)
        {
            JOptionPane.showMessageDialog(null,"Balance not allowed");
            return false;
        }
        if(jTextField4.getText().length()!=10)
        {
        
            JOptionPane.showMessageDialog(null,"Invalid Mobile no.");
            return false;
        }
        return true;
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
        try{
        String spon_id=jTextField1.getText();
        String c_id=jTextField2.getText();
        String cname=jTextField3.getText();
        String phone=jTextField4.getText();
        String balance=jTextField5.getText();
        String address=jTextArea1.getText();
       
        
            if(verifyText()){
                Product p1=new Product();
                p1.addCustomer('i',c_id,spon_id,cname,phone,balance,address);
                
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Price!!!");
        }
    }
    private void jTextField2KeyTyped(KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar()))
        {
        evt.consume();}
    }

    private void jTextField5KeyTyped(KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar()))
        {
        evt.consume();}
    }

    private void jTextField4KeyTyped(KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar()))
        {
        evt.consume();}
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
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCustomer().setVisible(true);
            }
        });
    }

    
}
