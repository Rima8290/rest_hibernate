package com.lti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("carPartsImpl1")
public class CarPartsInventoryImpl1 implements CarPartsInventory{

	public void addNewPart(CarPart carpart) {
		Connection conn=null;  //manages the connection between the app and jdbc
		PreparedStatement stmt=null;  //help us to execute sql statements
		ResultSet rs =null; //helps us to ftech the result of a selected query
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
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
		
		return null;
		
	}
}
