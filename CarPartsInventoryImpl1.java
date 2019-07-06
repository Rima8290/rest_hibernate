package com.lti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("carPartsImpl1")
public class CarPartsInventoryImpl1 implements CarPartsInventory {

 public void addNewPart(CarPart carPart) {
	    Connection con = null;
		PreparedStatement st = null;
		
		 
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
				 String sql="insert into carParts values(?,?,?,?)";
				  st=con.prepareStatement(sql);
	                           st.setInt(1,carPart.getPartNo());   
				 		       st.setString(2,carPart.getPartName()); 
				 		       st.setString(3,carPart.getCarModel()); 
				 		       st.setInt(4,carPart.getQuantity());  
				 	            
				 	          st.executeUpdate(); 
				 		}
			catch(ClassNotFoundException ex){
						
						System.out.println("JDBC driver not found");
						
					}
					catch(SQLException ex) {
						ex.printStackTrace();
					}
					finally {
						
						try {
							con.close();
						}
						catch(Exception ex) {
							
						
					}
			
			
					}
			
 }
	
 
	 public List<CarPart> getAvailableParts(){
		return null;
		 
	 }
}
