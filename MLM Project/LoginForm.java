

import java.sql.*;
import java.util.*;
import java.util.loging.*;
import java.swing.*;


/**
 *
 * @author Kaushal Vasava
 */

public class LoginForm extends JFrame {

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPasswordField jPasswordField1;
    private JTextField jTextField1;
    
    public LoginForm() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(420, 525));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new Font("Tahoma", 1, 24)); 
        jLabel1.setText("Customer Login");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 80, 200, 28);

        jLabel2.setFont(new Font("Tahoma", 1, 14)); 
        jLabel2.setText("Username:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 200, 74, 17);

        jLabel3.setFont(new Font("Tahoma", 1, 14)); 
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 270, 74, 17);

        jTextField1.setFont(new Font("Tahoma", 0, 16)); 
        jPanel1.add(jTextField1);
        jTextField1.setBounds(150, 200, 177, 26);

        jPasswordField1.setFont(new Font("Tahoma", 0, 16)); 
        jPasswordField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(150, 270, 177, 26);

        jButton1.setFont(new Font("Tahoma", 1, 15));
        jButton1.setText("Login");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(110, 380, 73, 27);

        jButton2.setFont(new Font("Tahoma", 1, 15)); 
        jButton2.setText("Cancel");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(260, 380, 90, 27);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 411, 481);

        pack();
    }

    private void jPasswordField1ActionPerformed(ActionEvent evt) {

    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        String url="jdbc:oracle:thin:@localhost:1521:XE";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded");
			Connection con=DriverManager.getConnection(url,"dhaval","dhaval");
			System.out.println("Connection Established "+con);
                        
                        PreparedStatement p1;
			
                        p1=con.prepareStatement("SELECT * from USER_INFO where uname = ? and password = ?");
                        p1.setString(1,jTextField1.getText());
                        p1.setString(2,String.valueOf(jPasswordField1.getPassword()));
                        
                        ResultSet r1=p1.executeQuery();
                        
                        if(r1.next())   
                        {
                            UserLogin h1=new UserLogin(jTextField1.getText());
                                h1.setVisible(true);
                                h1.pack();
                                h1.setLocationRelativeTo(null);
                                h1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                
                                PreparedStatement p2;
                                p2=con.prepareStatement("SELECT * from customer where cid = ?");
                                p2.setString(1,jTextField1.getText());
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
                        else
                            System.out.println("NO");
		}
	
		catch (ClassNotFoundException e)
		{
			System.out.println("Driver not loaded " +e.getMessage());

		}
		catch (SQLException e)
		{
			System.out.println("Connection not Established "+e.getMessage());
		}
                setVisible(false);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.dispose();
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
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    
    }
}
