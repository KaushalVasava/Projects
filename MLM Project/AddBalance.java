
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;

/**
 *
 * @author Kaushal Vasava
 */

public class AddBalance extends JFrame {

    public String cid;
    
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JTextField jTextField1;

    Connection c1=null;
      
    public AddBalance()
    {
      initComponents();
    }
    public AddBalance(String c) {
        cid =c;
        initComponents();
      
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c1=DriverManager.getConnection(url,"dhaval","dhaval");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Driver not loaded " +e.getMessage());
		}
		catch (SQLException e)
		{
			System.out.println("Connection not Established "+e.getMessage());
		}
            PreparedStatement p1;
            
             try{
                 p1=c1.prepareStatement("select balance from customer where cid=?");
                 p1.setString(1,cid);
                 ResultSet rs=p1.executeQuery();
                 while(rs.next())
                 {
                   jLabel3.setText(rs.getString(1));
                 }
                }         
                catch(SQLException e)
                {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
                }
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 350));

        jPanel1.setBackground(new Color(204, 204, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new Font("Tahoma", 1, 18));
        jLabel1.setText("Add Balance");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 40, 123, 31);

        jLabel2.setFont(new Font("Tahoma", 0, 16)); 
        jLabel2.setText("Available Balance:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(42, 112, 128, 20);

        jLabel3.setFont(new Font("Tahoma", 0, 16)); 
        jLabel3.setText("Balance");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 110, 110, 28);

        jLabel4.setFont(new Font("Tahoma", 0, 16)); 
        jLabel4.setText("Enter Amount:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 170, 105, 20);

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
        jTextField1.setBounds(180, 160, 133, 35);

        jButton1.setFont(new Font("Tahoma", 0, 15)); 
        jButton1.setText("Add");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(145, 247, 77, 27);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
     
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
        if(Integer.parseInt(jTextField1.getText())<500){
            JOptionPane.showMessageDialog(null,"Balance must be >=500"); 
        }
        else{
            PreparedStatement p1;
            String s1=jTextField1.getText();
            try{
                p1=c1.prepareStatement("update customer set balance = balance +  ? where cid = ?");
                p1.setString(1,s1);
                p1.setString(2,cid);
          
                  if(p1.executeUpdate()>0)
                     {
                      JOptionPane.showMessageDialog(null,"Balance added"); 
                     }
                }          
            catch(SQLException e)
            {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        setVisible(false);
    }

    private void jTextField1KeyTyped(KeyEvent evt) {
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
            Logger.getLogger(AddBalance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AddBalance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AddBalance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AddBalance.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBalance().setVisible(true);
            }
        });
    }
}
