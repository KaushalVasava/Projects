
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.*;
import java.util.*;
/**
 *
 * @author Kaushal Vasava
 */

public class HomePage extends JFrame {
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu5;
    private JMenu jMenu6;
    private JMenuBar jMenuBar2;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem jMenuItem6;
    private JPanel jPanel1;
    private JSeparator jSeparator1;

    public HomePage() {
        initComponents();
    }

    private void initComponents() {

        jMenu5 = new JMenu();
        jLabel4 = new JLabel();
        jMenu2 = new JMenu();
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        jLabel6 = new JLabel();
        jSeparator1 = new JSeparator();
        jMenuBar2 = new JMenuBar();
        jMenu6 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenuItem4 = new JMenuItem();
        jMenu1 = new JMenu();
        jMenuItem2 = new JMenuItem();
        jMenuItem3 = new JMenuItem();
        jMenuItem5 = new JMenuItem();
        jMenu3 = new JMenu();
        jMenuItem6 = new JMenuItem();

        jMenu5.setText("jMenu5");

        jLabel4.setText("jLabel4");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("MLM\n");

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setForeground(new Color(0, 204, 204));
        jPanel1.setLayout(null);

        jLabel3.setFont(new jFont("Arial", 0, 48)); // NOI18N
        jLabel3.setForeground(new Color(51, 51, 51));
        jLabel3.setText("Multilevel Marketing");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(390, 10, 490, 96);

        jLabel6.setIcon(new ImageIcon(getClass().getResource("/Images/MLM Structure.png"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(240, 110, 820, 570);

        jSeparator1.setForeground(new Color(0, 0, 0));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 100, 1160, 10);

        jMenu6.setIcon(new ImageIcon(getClass().getResource("/Images/nmpi_icon_1.png"))); // NOI18N
        jMenu6.setText("Product");

        jMenuItem1.setIcon(new ImageIcon(getClass().getResource("/Images/add-to-cart-icon.png"))); // NOI18N
        jMenuItem1.setText("Add");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuItem4.setIcon(new ImageIcon(getClass().getResource("/Images/manage.png"))); 
        jMenuItem4.setText("Manage");
        jMenuItem4.addActionListener(new ActionListener()
                    public void actionPerformed(ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuBar2.add(jMenu6);

        jMenu1.setIcon(new ImageIcon(getClass().getResource("/Images/download.png"))); 
        jMenu1.setText("Customer");

        jMenuItem2.setIcon(new ImageIcon(getClass().getResource("/Images/add-to-cart-icon.png")));
        jMenuItem2.setText("Add ");
        jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new ImageIcon(getClass().getResource("/Images/key.png"))); 
        jMenuItem3.setText("Login");
        jMenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setIcon(new ImageIcon(getClass().getResource("/Images/view.png")));
        jMenuItem5.setText("View Customer");
        jMenuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar2.add(jMenu1);

        jMenu3.setIcon(new ImageIcon(getClass().getResource("/Images/help.png"))); 
        jMenu3.setText("Help");

        jMenuItem6.setIcon(new ImageIcon(getClass().getResource("/Images/about us.png"))); 
        jMenuItem6.setText("About Us");
        jMenuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
        );

        pack();
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt){
        AddProduct h1=new AddProduct();
	    h1.setVisible(true);
	    h1.pack();
	    h1.setLocationRelativeTo(null);
        h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void jMenuItem3ActionPerformed(ActionEvent evt) {

        LoginForm h1=new LoginForm();
	    h1.setVisible(true);
	    h1.pack();
	    h1.setLocationRelativeTo(null);
        h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void jMenuItem4ActionPerformed(ActionEvent evt) {
        ManageProduct h1=new ManageProduct();
	h1.setVisible(true);
	h1.pack();
	h1.setLocationRelativeTo(null);
        h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        AddCustomer h1=new AddCustomer();
	h1.setVisible(true);
	h1.pack();
	h1.setLocationRelativeTo(null);
        h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void jMenuItem5ActionPerformed(ActionEvent evt) {

     ViewCustomer h1=new ViewCustomer();
	 h1.setVisible(true);
	 h1.pack();
	 h1.setLocationRelativeTo(null);
     h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void jMenuItem6ActionPerformed(ActionEvent evt) {
       JOptionPane.showMessageDialog(null,"Product Version : 1.0 \n\n Created by: \n Dhaval Thummar \n Deval Vala \n Jayesh Varchand \n Kaushal Vasava");
    }
    
    public static void main(String args[]) {
       /* 
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } 
       // catch (InstantiationException ex) {
         //   Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        //} 
        catch (IllegalAccessException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
       //  catch (UnsupportedLookAndFeelException ex) {
         //   Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        //}*/
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
}
