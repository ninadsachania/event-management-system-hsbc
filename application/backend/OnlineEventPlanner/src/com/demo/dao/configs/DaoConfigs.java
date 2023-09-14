package com.demo.dao.configs;

//configurations required to connect the database
public interface DaoConfigs {
	String CONURL = "Jdbc:mysql://localhost:3306/eventplanner";
	String USERNAME = "root";
	String PASSWORD = "cloud";
	String DRIVERCLASSNAME = "com.mysql.cj.jdbc.Driver";
}
