import java.sql.*;
import java.util.logging.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Kaushal Vasava
 */

public class UserLogin extends JFrame {

    public static String cid;

    private JButton jButton1;
    private JButton jButton2;
    public static JLabel jLabel1;
    public static JLabel jLabel2;
    public static JLabel jLabel3;
    public static JLabel jLabel4;
    public static JLabel jLabel5;
    public static JLabel jLabel6;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem jMenuItem6;
    private JPanel jPanel1;
    
    public UserLogin(String c) {
        cid=c;
        initComponents();
        setTitle("Customer Home\n");
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jButton2 = new JButton();
        jMenuBar1 = new JMenuBar();
        jMenu3 = new JMenu();
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenu1 = new JMenu();
        jMenuItem3 = new JMenuItem();
        jMenuItem4 = new JMenuItem();
        jMenu2 = new JMenu();
        jMenuItem5 = new JMenuItem();
        jMenuItem6 = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1230, 701));
        getContentPane().setLayout(null);

        jLabel1.setFont(new Font("Tahoma", 0, 24)); 
        jLabel1.setText("Name:");

        jLabel2.setFont(new Font("Tahoma", 0, 24)); 
        jLabel2.setText("ID:");

        jLabel3.setFont(new Font("Tahoma", 0, 24)); 
        jLabel3.setText("Balance:");

        jButton1.setFont(new Font("Tahoma", 0, 16));
        jButton1.setText("Distrubotuor Status");

        jLabel4.setFont(new Font("Tahoma", 0, 24)); 
        jLabel4.setText("Contact no:");

        jLabel5.setFont(new Font("Tahoma", 0, 24)); 
        jLabel5.setText("Sponser ID:");

        jLabel6.setFont(new Font("Tahoma", 0, 24)); 
        jLabel6.setText("Address:");

        jButton2.setFont(new Font("Tahoma", 0, 16));
        jButton2.setText("Refresh");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
                        .addGap(183, 911, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(155, 155, 155))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton2)))
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addComponent(jLabel5)
                .addGap(49, 49, 49)
                .addComponent(jLabel3)
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addGap(60, 60, 60)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, -30, 1230, 670);

        jMenu3.setIcon(new ImageIcon(getClass().getResource("/Images/home.png"))); 
        jMenu3.setText("Home");

        jMenuItem1.setText("Update Profile");
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu1.setIcon(new ImageIcon(getClass().getResource("/Images/payment.png")));
        jMenu1.setText("Payment");

        jMenuItem3.setText("Add Balance");
        jMenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Transactions");
        jMenuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new ImageIcon(getClass().getResource("/Images/icon_shop.png"))); 
        jMenu2.setText("Order");

        jMenuItem5.setText("New Order");
        jMenuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Order History");
        jMenuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }

    private void jMenuItem1ActionPerformed(ActionEvent evt) {
        UpdateProfile h1=new UpdateProfile(cid);
	    h1.setVisible(true);
	    h1.pack();
	    h1.setLocationRelativeTo(null);
        h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void jMenuItem2ActionPerformed(ActionEvent evt) {
        LogOut h1=new LogOut(this);
	    h1.setVisible(true);
	    h1.pack();
	    h1.setLocationRelativeTo(null);
        h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void jMenuItem3ActionPerformed(ActionEvent evt) {
        AddBalance h1=new AddBalance(cid);
	    h1.setVisible(true);
	    h1.pack();
	    h1.setLocationRelativeTo(null);
        h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void jButton2ActionPerformed(ActionEvent evt) {
        setVisible(false);
       
		String url="jdbc:oracle:thin:@localhost:1521:XE";
               try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded");
			Connection c1=DriverManager.getConnection(url,"dhaval","dhaval");
			System.out.println("Connection Established "+c1);
                        
                  
                            UserLogin h1=new UserLogin(cid);
                                h1.setVisible(true);
                                h1.pack();
                                h1.setLocationRelativeTo(null);
                                h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                
                                PreparedStatement p2;
                                p2=c1.prepareStatement("SELECT * from customer where cid = ?");
                                p2.setString(1,cid);
                                ResultSet r2=p2.executeQuery();
                                
                                if(r2.next())
                                    {

                                        String s1=r2.getString(1);
                                        String s2=r2.getString(2);
                                        String s3=r2.getString(3);
                                        String s4=r2.getString(4);
                                        String s5=r2.getString(5);
                                        String s6=r2.getString(6);
                                        UserLogin.jLabel2.setText("ID: "+s1);
                                        UserLogin.jLabel1.setText("Name: "+s2);
                                        UserLogin.jLabel3.setText("Balance: "+s4);
                                        UserLogin.jLabel4.setText("Contact: "+s3);
                                        UserLogin.jLabel5.setText("Sponser ID: "+s6);
                                        UserLogin.jLabel6.setText("Address: "+s5);
                                    }
                                                  //  UserLogin.jLabel1.setText();                        
		}
	
		catch (ClassNotFoundException e)
		{
			System.out.println("Driver not loaded " +e.getMessage());

		}
		catch (SQLException e)
		{
			System.out.println("Connection not Established "+e.getMessage());
		}
    }

    private void jMenuItem4ActionPerformed(ActionEvent evt) {
        TransHistory h1=new TransHistory(cid);
	    h1.setVisible(true);
	    h1.pack();
	    h1.setLocationRelativeTo(null);
        h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void jMenuItem5ActionPerformed(ActionEvent evt) {
        NewOrder h1=new NewOrder(cid);
	    h1.setVisible(true);
	    h1.pack();
	    h1.setLocationRelativeTo(null);
        h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void jMenuItem6ActionPerformed(ActionEvent evt) {
        OrderHistory h1=new OrderHistory(cid);
	    h1.setVisible(true);
	    h1.pack();
	    h1.setLocationRelativeTo(null);
        h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin(cid).setVisible(true);
            }
        });
    }
}
