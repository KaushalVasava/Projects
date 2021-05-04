
import java.util.logging.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Kaushal Vasava
 */

public class UpdateProfile extends JFrame {

    public static String cid;

    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JTextField jTextField2;
     Connection c1=null;
    public UpdateProfile(String c) {
        cid=c;
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
         try{
                
                                PreparedStatement p2;
                                p2=c1.prepareStatement("SELECT * from customer where cid = ?");
                                p2.setString(1,cid);
                                ResultSet r2=p2.executeQuery();
                                
                                if(r2.next())
                                    { 
                                        String s3=r2.getString(3);
                                        String s5=r2.getString(5);
                                        jTextField1.setText(s3);
                                        jTextField2.setText(s5);
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
        jButton1 = new JButton();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Tahoma", 1, 24)); 
        jLabel1.setText("Update Details");
        jLabel2.setFont(new Font("Tahoma", 0, 16)); 
        jLabel2.setText("Adddress:");
        jLabel3.setFont(new Font("Tahoma", 0, 16)); 
        jLabel3.setText("Contact No:");

        jButton1.setFont(new Font("Tahoma", 0, 16)); 
        jButton1.setText("Update");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

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

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(jLabel3)
                    .addContainerGap(284, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(111, 111, 111))
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(281, Short.MAX_VALUE)))
        );

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

    private void jTextField2ActionPerformed(ActionEvent evt) {

    }

    private void jButton1ActionPerformed(ActionEvent evt) {
       PreparedStatement p1;                                                
       try{           
            if(jTextField1.getText().equals("") || jTextField2.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Empty Field");
            }              
            else{                 
                 p1=c1.prepareStatement("update customer set phone = ? , address = ? where cid = ?");
                 p1.setString(1,jTextField1.getText());
                 p1.setString(2,jTextField2.getText());
                 p1.setString(3,cid);
                 if(p1.executeUpdate()>0)
                 {
                      JOptionPane.showMessageDialog(null,"Record Updated"); 
                 }
                }          
          }
          catch(SQLException e)
          {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
          }
    }
    private void jTextField2KeyTyped(KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar()))
        {
         evt.consume();
        }  
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
            Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(UpdateProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateProfile(cid).setVisible(true);
            }
        });
    }
}
