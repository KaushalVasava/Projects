
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;


public class LogOut extends JFrame {

    UserLogin u1;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JPanel jPanel1;
    
    public LogOut()
    {
         initComponents();
    
    public LogOut(UserLogin u1) {
        this.u1=u1;
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setPreferredSize(new Dimension(400, 195));

        jPanel1.setBackground(new Color(0, 204, 204));
        jPanel1.setBorder(new border.MatteBorder(null));
        jPanel1.setLayout(null);

        jLabel1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
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
            .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        u1.setVisible(false);
        setVisible(false);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
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
            Logger.getLogger(LogOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LogOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LogOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LogOut.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogOut().setVisible(true);
            }
        });
    }
}
