
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
public class NewOrder extends JFrame {

    Connection c1;
    String value="";
    String cid;

    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    public static JTable jTable1;
    
    public void createTable(){
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
                p1=c1.prepareStatement("SELECT * FROM product WHERE pid LIKE ? or lower(pname) LIKE ? order by pid");
                p1.setString(1,"%"+value.toLowerCase()+"%");
                p1.setString(2,"%"+value.toLowerCase()+"%");
                ResultSet rs=p1.executeQuery();
                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                
                Object[] row;
                
                while(rs.next())
                {
                    row=new Object[4];
                   // row[0]=rs.getInt(1);
                    row[1]=rs.getString(1);
                    row[2]=rs.getString(2);
                    row[3]=rs.getString(4);
                    
                    model.addRow(row);
                }
            }          
            catch(SQLException e)
            {
                 Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
            }
    }
    public NewOrder()
    {
         initComponents();
         jTable1.setRowHeight(40);
         this.createTable();
    }
    public NewOrder(String c) {
        cid =c;
        initComponents();
        jTable1.setRowHeight(40);
        this.createTable();
       
    }
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Tahoma", 1, 22));
        jLabel1.setText("Order");

        jTable1.setFont(new Font("Tahoma", 0, 16));
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select", "Product ID", "Product Name", "Price", "Enter Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jButton1.setFont(new Font("Tahoma", 0, 15)); 
        jButton1.setText("Submit");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

    private void jButton1ActionPerformed(ActionEvent evt) {
        OrderConfirm h1=new OrderConfirm(cid);
        System.out.println("cid is "+cid);
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
            Logger.getLogger(NewOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NewOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NewOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(NewOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewOrder().setVisible(true);
            }
        });
    }
}
