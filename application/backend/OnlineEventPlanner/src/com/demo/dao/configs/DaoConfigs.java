package com.demo.dao.configs;

//configurations required to connect the database
public interface DaoConfigs {
	String CONURL = "jdbc:mysql://localhost:3306/eventplanner?useSSL=false";
	String USERNAME = "root";
	String PASSWORD = "root";
	String DRIVERCLASSNAME = "com.mysql.cj.jdbc.Driver";
}
