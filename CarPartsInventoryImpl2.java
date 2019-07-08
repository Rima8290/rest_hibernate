package com.lti.component;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("carPartsImpl2")
public class CarPartsInventoryImpl2 implements CarPartsInventory{

	@Autowired
	@Qualifier("dataSource1")
	private DataSource dataSource;
	
	public void addNewPart(CarPart carpart) {
		Connection conn=null;  //manages the connection between the app and jdbc
		PreparedStatement stmt=null;  //help us to execute sql statements
		ResultSet rs =null; //helps us to fetch the result of a selected query
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			//------------ Spring for database connection
			
			conn = dataSource.getConnection();
			
			String sql="insert into TBL_CARPARTS values(?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1,carpart.getPartno());
			stmt.setString(2,carpart.getPartname());
			stmt.setString(3,carpart.getCarModel());
			stmt.setInt(4,carpart.getQuantity());
			 
			stmt.executeUpdate();
			
		
		}
		 catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
			e.getMessage();	
			}
	}	
	}
	public List<CarPart> getAvailableParts(){
		Connection conn=null;  //manages the connection between the app and jdbc
		PreparedStatement stmt=null;  //help us to execute sql statements
		ResultSet rs =null; //helps us to fetch the result of a selected query
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			//------------ Spring for database connection
			
			conn = dataSource.getConnection();
			
			String sql="select * from TBL_CARPARTS";
			
			stmt=conn.prepareStatement(sql);
			rs= stmt.executeQuery();
			
			List<CarPart> car = new ArrayList<CarPart>();
			while(rs.next()) {
			
			CarPart c = new CarPart();
			c.setPartno(rs.getInt(1));
			c.setPartname(rs.getString(2));
			c.setCarModel(rs.getString(3));
			c.setQuantity(rs.getInt(4));
		
			 
			
			}
		
		}
		 catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
			e.getMessage();	
			}
	}	
		
		
		return null;
		
	}
}
