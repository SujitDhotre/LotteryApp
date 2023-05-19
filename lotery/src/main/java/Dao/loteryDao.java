package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bo.lotery;



public class loteryDao {
	public static Connection getConnection() {
		Connection con =null;
		try {
			String url="jdbc:mysql://localhost:3306/Lottery";
			String username="root";
			String password="Sujit@5";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			
		}catch(Exception e)
		{
			
		}
		return con;
		
	}
	
	//inseting the lottery Number
	public static int insert(lotery em)
	{
		int status=0;
		try
		{
			Connection con=loteryDao.getConnection();
			String sql="insert into winner(number) values(?)";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, em.getNumber());
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static boolean Winner(String number ) throws SQLException
	{
		boolean status=false;
		try {
			
			Connection con=loteryDao.getConnection();
			String sql="select * from winner where number=?";
			PreparedStatement ps=con.prepareStatement(sql);
			lotery em;
			
			ps.setString(1, number);

			
			
			ResultSet rs=ps.executeQuery();
			status =rs.next();
			
		}catch (Exception e)
		{
			System.out.println(e);
			
			
		}
		
		
		return status;
	}


}
