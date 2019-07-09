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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("carPartsImpl3")
public class CarPartsInventoryImpl3 implements CarPartsInventory{

	@Autowired
	@Qualifier("dataSource1")
	private DataSource dataSource;
	
	public void addNewPart(CarPart carpart) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);	
			
		jt.update("insert into TBL_CARPARTS values(?,?,?,?)",
			              carpart.getPartno(),
			              carpart.getPartname(),
		                  carpart.getCarModel(),
			              carpart.getQuantity());
			 }
	
	class CarPartRowMapper implements RowMapper<CarPart>{
	
		public CarPart mapRow(ResultSet rs, int rowNum) throws SQLException {  // for each row maprow will be called
		CarPart carPart = new CarPart();
		
		carPart.setPartno(rs.getInt(1));
		carPart.setPartname(rs.getString(2));
		carPart.setCarModel(rs.getString(3));
		carPart.setQuantity(rs.getInt(4));
	
		return carPart;
	}	
}	

	public List<CarPart> getAvailableParts() {
		
        JdbcTemplate jt = new JdbcTemplate(dataSource);	
		String sql = "select * from TBL_CARPARTS";
		List<CarPart> list = jt.query(sql, new CarPartRowMapper());
		return list;
	}
}