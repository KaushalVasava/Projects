

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.logging.
/**
 *
 * @author Kaushal Vasava
 */

public class OrderHistory extends JFrame {

    public String cid;
    
    private JScrollPane jScrollPane2;
    private JTable jTable1;
    
    Product p1=new Product();
    
    public OrderHistory() {
        initComponents();
        jTable1.setRowHeight(40);
    }
    
    public OrderHistory(String c) {
        cid=c;
        initComponents();
        jTable1.setRowHeight(40);
        p1.fillOrder(jTable1, cid);
    }

    private void initComponents() {

        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new Font("Tahoma", 0, 16)); 
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Product name", "Date", "Amount"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }

    public static void main(String args[]){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(OrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(OrderHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderHistory().setVisible(true);
            }
        });
    }

   
}
