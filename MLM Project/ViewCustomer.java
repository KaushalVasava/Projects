
import java.sql.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;

/**
 *
 * @author Kaushal Vasava
 */

public class ViewCustomer extends JFrame {
    
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    private JTextField jTextField1;
    private JTree jTree1;

    Product p1=new Product();
    public ViewCustomer() {
        initComponents();
        p1.fillCustomer(jTable1,"");
        jTable1.setRowHeight(40);
    }

    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jScrollPane2 = new JScrollPane();
        jTree1 = new JTree();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(0, 153, 153));
        setPreferredSize(new Dimension(1130, 850));
        getContentPane().setLayout(null);

        jScrollPane1.setBackground(new Color(0, 153, 153));
        jScrollPane1.setForeground(new Color(0, 153, 153));

        jTable1.setFont(new Font("Tahoma", 0, 18)); 
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Sponser ID", "Customer Name", "Balance", "Mobile No.", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 193, 1060, 220);

        jLabel1.setFont(new Font("Tahoma", 1, 36)); 
        jLabel1.setText("View Customer");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(390, 40, 273, 44);

        jLabel2.setFont(new Font("Tahoma", 0, 18)); 
        jLabel2.setText("Search:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 139, 58, 22);

        jTextField1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                jTextField1KeyReleased(evt);
        
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(75, 136, 323, 32);

        jTree1.setBackground(new Color(240, 240, 240));
        jTree1.setFont(new Font("Tahoma", 0, 20)); 
        DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("root");
        jTree1.setModel(new DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jTree1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(160, 500, 310, 250);

        jButton1.setFont(new Font("Tahoma", 0, 15));
        jButton1.setText("Tree");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(29, 500, 80, 27);

        pack();
    }

    private void jTextField1KeyReleased(KeyEvent evt) {
        jTable1.setModel(new DefaultTableModel(null, new Object[]{"Customer ID", "Sponser ID", "Customer Name", "Balance", "Mobile No.", "Address"}));
        p1.fillCustomer(jTable1, jTextField1.getText());
    }
    private void jButton1ActionPerformed(ActionEvent evt) {

       try
		{
			int rowIndex = jTable1.getSelectedRow();
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        String s2=model.getValueAt(rowIndex, 0).toString();
        
                        DefaultMutableTreeNode root = new DefaultMutableTreeNode(s2+"  "+model.getValueAt(rowIndex, 2).toString());
                         for(int i=1;i<model.getRowCount();i++)
                         {
                             if(model.getValueAt(i,1).equals(s2))
                             {
                                 rowIndex=i;
                                 String s1= model.getValueAt(rowIndex, 0).toString();
                                 DefaultMutableTreeNode row = new DefaultMutableTreeNode(s1+"  "+model.getValueAt(rowIndex, 2).toString());
                                
                                for(int j=1;j<model.getRowCount();j++)
                                    {
                                        if(model.getValueAt(j,1).equals(s1))
                                        {
                                            rowIndex=j;
                                            String s3= model.getValueAt(rowIndex, 0).toString();

                                            DefaultMutableTreeNode node = new DefaultMutableTreeNode(s3+"  "+model.getValueAt(rowIndex, 2).toString());
                                            row.add(node);
                                        }
                                    }
                                 root.add(row);
                             }
                         }
                      DefaultTreeModel m1 = new DefaultTreeModel(root);
                      jTree1.setModel(m1);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,"Select Customer");
                        System.out.print(e.getMessage());
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
            Logger.getLogger(ViewCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCustomer().setVisible(true);
            }
        });
    }

    
}
