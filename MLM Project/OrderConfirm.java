
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Kaushal Vasava
 */

public class OrderConfirm extends JFrame {

    String cid;

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JPanel jPanel1;

    public OrderConfirm(){
    
    }
    public OrderConfirm(String c) {
        cid=c;
        initComponents();
        
    }
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new MatteBorder(null));
        jPanel1.setLayout(null);

        jLabel1.setFont(new Font("Tahoma", 0, 18)); 
        jLabel1.setText("Are you sure?");
        jLabel1.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 50, 120, 28);

        jButton1.setText("No");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(260, 120, 47, 25);

        jButton2.setText("Yes");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(80, 120, 53, 25);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        setVisible(false);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        Connection c1=null;
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
      
        PreparedStatement p2;
        System.out.println("ok1");
        DefaultTableModel model = (DefaultTableModel)NewOrder.jTable1.getModel();
        float price,amt1=0,amt=0;
        int qty,oid;
        String s1="";
        try{
                p2=c1.prepareStatement("SELECT max(o_id) FROM order_detail"); 
                ResultSet rs=p2.executeQuery();
                rs.next();
                s1 = rs.getString(1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        oid=Integer.parseInt(s1)+1;
        
        for(int i=0; i<model.getRowCount();i++){
            if(model.getValueAt(i,0)==null);
            else if(model.getValueAt(i,0)!=null && model.getValueAt(i,0)==Boolean.TRUE)
            {
                qty = Integer.parseInt(model.getValueAt(i,4).toString());
                price = Float.parseFloat(model.getValueAt(i,3).toString());
                amt1 = qty*price;
                System.out.println(model.getValueAt(i,1).toString());
                System.out.println(String.valueOf(amt1));
                System.out.println(String.valueOf(qty));
      
             try{
              
                        p2=c1.prepareStatement("INSERT into order_detail values(?,?,?,?)");
                        p2.setString(1,model.getValueAt(i,1).toString());
                        p2.setString(4,String.valueOf(amt1));
                        p2.setString(3,String.valueOf(qty));
                        p2.setString(2,String.valueOf(oid));
                        p2.executeQuery();
                
                }          
    
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            
             amt=amt+amt1; 
            }
            
       }
        try{
              
                        p2=c1.prepareStatement("INSERT into order_table values(?,?,sysdate,?)");
                        p2.setString(1,String.valueOf(oid));
                        p2.setString(3,String.valueOf(amt));
                        p2.setString(2,cid);
                        p2.executeQuery();
                
                }          
    
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
        JOptionPane.showMessageDialog(null,"Order Placed"); 
        setVisible(false);
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
            Logger.getLogger(OrderConfirm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(OrderConfirm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OrderConfirm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(OrderConfirm.class.getName()).log(Level.SEVERE, null, ex);
        }
        Queue.invokeLater(new Runnable() {
            public void run() {
                new OrderConfirm().setVisible(true);
            }
        });
    }

    
}
