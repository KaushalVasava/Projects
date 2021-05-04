/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mlm;

/**
 *
 * @author Dhaval Thummar
 */

import java.sql.*;
public class MyConnection
{
	public static Connection getConnection()
	{
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
		return c1;
	}
}