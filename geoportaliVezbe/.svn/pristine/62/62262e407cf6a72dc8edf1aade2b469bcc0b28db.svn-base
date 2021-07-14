package eterrapn.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Transactional
@Repository
public class Impl {

	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ResourceLoader resourceLoader;


	private Connection con = null;

	public JasperPrint exportPdfFile(String izvestaj, HashMap<String, Object> params, Connection con) throws SQLException, JRException, IOException {

		System.out.println("Usao eksport pdf");
		JasperPrint jp; 

		String path = "C:/eterrapn/";

		jp = JasperFillManager.fillReport( new FileInputStream(new File(path += izvestaj)),params, con);

		return jp;
	}


	public Connection getConnection() throws SQLException
	{

		String connectionUrl = "jdbc:sqlserver://192.168.1.120:1433;databaseName=terrapn;user=sa;password=sa";
	//	String connectionUrl = "jdbc:sqlserver://10.10.15.10:1433;databaseName=terrapn;user=terrasoft;password=terrasoft";

		try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");} 
		catch (Exception e) {
			e.printStackTrace();
		}

		Connection con = DriverManager.getConnection(connectionUrl); 

		return con;
	}




}
