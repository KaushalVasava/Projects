


import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Product {
       
       Connection c1=null;
       
       public Product()
       {
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
       }
       
       public void addProduct(char operation, String pid, String pname, String tot_q, String price)
       {
		
          PreparedStatement p1;
                     
          if(operation == 'i')
          {
             try{
                p1=c1.prepareStatement("INSERT INTO product(pid,pname,tot_qty,price) VALUES(?,?,?,?)");
                p1.setString(1,pid);
                p1.setString(2,pname);
                p1.setString(3, tot_q);
                p1.setString(4,price);
                if(p1.executeUpdate()>0)
                {
                      JOptionPane.showMessageDialog(null,"New Product added"); 
                }
                }          
                
                catch(SQLIntegrityConstraintViolationException e)
                {
                    JOptionPane.showMessageDialog(null,"Product already added");
                }
            
                catch(SQLException e)
                {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
                }
            }
         
             if(operation == 'u')
            {
                try{
                p1=c1.prepareStatement("update product set pid = ? , pname = ?, tot_qty = ?, price = ? where pid = ?");
                p1.setString(1,pid);
                p1.setString(2,pname);
                p1.setString(3, tot_q);
                p1.setString(4,price);
                p1.setString(5,pid);
                  if(p1.executeUpdate()>0)
                     {
                      JOptionPane.showMessageDialog(null,"Record Updated"); 
                     }
                }          
                
                catch(SQLIntegrityConstraintViolationException e)
                {
                    JOptionPane.showMessageDialog(null,"Product already added");
                }
            
                catch(SQLException e)
                {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
                }
            }
             
             //Delete
             if(operation == 'd')
             {
                try{
                p1=c1.prepareStatement("delete from product where pid = ?");
                p1.setString(1,pid);

                  if(p1.executeUpdate()>0)
                     {
                      JOptionPane.showMessageDialog(null,"Record Deleted"); 
                     }
                }          
                
            
                catch(SQLException e)
                {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            
        }
        
     public void fillProduct(JTable table, String value)
     {
            PreparedStatement p1;
            try{
                p1=c1.prepareStatement("SELECT * FROM product WHERE pid LIKE ? or lower(pname) LIKE ? order by pid");
                p1.setString(1,"%"+value.toLowerCase()+"%");
                p1.setString(2,"%"+value.toLowerCase()+"%");
                ResultSet rs=p1.executeQuery();
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                
                Object[] row;
                
                while(rs.next())
                {
                    row=new Object[4];
                    row[0]=rs.getInt(1);
                    row[1]=rs.getString(2);
                    row[2]=rs.getInt(3);
                    row[3]=rs.getFloat(4);
                    
                    model.addRow(row);
                }
                }          
                
            
                catch(SQLException e)
                {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
                }
     }
     
    
     public void addCustomer(char operation,String c_id,String spon_id,String cname,String phone,String balance,String address)
        {
         
            PreparedStatement p1;
            
          
            if(operation == 'i')
            {
                try{
                p1=c1.prepareStatement("INSERT INTO customer(cid,cname,phone,balance,address,spon_id) VALUES(?,?,?,?,?,?)");
                p1.setString(1,c_id);
                p1.setString(2,cname);
                p1.setString(3,phone);
                p1.setString(4,balance);
                p1.setString(5,address);
                p1.setString(6,spon_id);
                  if(p1.executeUpdate()>0)
                     {
                      JOptionPane.showMessageDialog(null,"New Customer added"); 
                     }
                }          
                
                catch(SQLIntegrityConstraintViolationException e)
                {
                    if(e.getMessage().startsWith("ORA-00001:"))
                    JOptionPane.showMessageDialog(null,"Customer already added");
                    
                    else
                    JOptionPane.showMessageDialog(null,"Sponser Does not exist");
                  
                }
            
                catch(SQLException e)
                {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            
         }
     
          public void fillCustomer(JTable table, String value)
          {
         
       
            PreparedStatement p1;
            try{
                p1=c1.prepareStatement("SELECT * FROM customer WHERE cid LIKE ? or lower(cname) LIKE ? or phone LIKE ? or spon_id LIKE ? or lower(address) LIKE ? order by cid");
                p1.setString(1,"%"+value.toLowerCase()+"%");
                p1.setString(2,"%"+value.toLowerCase()+"%");
                p1.setString(3,"%"+value.toLowerCase()+"%");
                p1.setString(4,"%"+value.toLowerCase()+"%");
                p1.setString(5,"%"+value.toLowerCase()+"%");
                
                ResultSet rs=p1.executeQuery();
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                
                Object[] row;
                
                 while(rs.next())
                 {
                    row=new Object[6];
                    row[0]=rs.getString(1);
                    row[1]=rs.getString(6);
                    row[2]=rs.getString(2);
                    row[3]=rs.getString(4);
                    row[4]=rs.getString(3);
                    row[5]=rs.getString(5);
                    
                    model.addRow(row);
                 }
                }          
                   
                catch(SQLException e)
                {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
                }
            }
          
            public void fillTransaction(JTable table, String cid)
            {
         
       
             PreparedStatement p1;
             try{
                p1=c1.prepareStatement("SELECT * FROM transaction WHERE cid=? order by tid desc");
                p1.setString(1,cid);
               
                
                ResultSet rs=p1.executeQuery();
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                
                Object[] row;
                
                while(rs.next())
                {
                    row=new Object[4];
                    row[0]=rs.getString(1);
                    row[1]=rs.getString(2);
                    row[2]=rs.getString(3);
                    row[3]=rs.getString(4);

                    
                    model.addRow(row);
                }
                }          
                
            
                catch(SQLException e)
                {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
                }
              }
            
            public void fillOrder(JTable table, String cid)
            {
         
       
             PreparedStatement p1;
             try{
                p1=c1.prepareStatement("SELECT t.o_id,p.pname,t.o_date,t.tot_amt FROM order_table t , order_detail d , product p "
                        + "where t.o_id=d.o_id and p.pid=d.pid and t.cid=?  order by t.o_id desc");
                p1.setString(1,cid);
               
                
                ResultSet rs=p1.executeQuery();
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                
                Object[] row;
                
                while(rs.next())
                {
                    row=new Object[4];
                    row[0]=rs.getString(1);
                    row[1]=rs.getString(2);
                    row[2]=rs.getString(3);
                    row[3]=rs.getString(4);

                    
                    model.addRow(row);
                }
                }          
                
            
                catch(SQLException e)
                {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE,null,e);
                }
     }
 
 
}
