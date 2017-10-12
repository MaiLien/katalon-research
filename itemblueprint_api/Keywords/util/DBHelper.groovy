package util

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword

public class DBHelper {

	private static Connection connection = null;

	private static final String DB_URL = "35.193.64.40";
	private static final String DB_PORT = "3306";
	private static final String DB_NAME = "psc";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "T@nch0ng26";

	@Keyword
	def connectDB(){

		try {
			String conn = "jdbc:mysql://" + DB_URL + ":" + DB_PORT + "/" + DB_NAME;
			Class.forName("com.mysql.jdbc.Driver");

			if(connection != null && !connection.isClosed()){
				connection.close();
			}
			connection = DriverManager.getConnection(conn, DB_USER, DB_PASS);
			return connection;
		} catch (Exception e) {
			e.printStackTrace()
		}
	}

	@Keyword
	def connectDB(String url, String port, String dbname, String username, String password){

		String conn = "jdbc:mysql://" + url + ":" + port + "/" + dbname;
		Class.forName("com.mysql.jdbc.Driver");

		if(connection != null && !connection.isClosed()){
			connection.close();
		}
		connection = DriverManager.getConnection(conn, username, password);
		return connection;
	}

	//	@Keyword
	//	def ResultSet executeQuery(String queryString) {
	//
	//		Statement stm = connection.createStatement();
	//		ResultSet rs = stm.executeQuery(queryString);
	//		return rs;
	//	}

	@Keyword
	def closeDatabaseConnection() {

		if(connection != null && !connection.isClosed()){
			connection.close();
		}
		connection = null;
	}

	@Keyword
	def boolean execute(String queryString) {
		
		try{
			Statement stm = connection.createStatement();
			boolean result = stm.execute(queryString);
			return result;
		} catch (Exception e){
			e.printStackTrace();
		}

	}
	
	@Keyword
	def boolean setSQLSafeUpdate(int status) {
		
		try{
			Statement stm = connection.createStatement();
			boolean result = stm.execute("SET SQL_SAFE_UPDATES = " + status + ";");
			return result;
		} catch (Exception e){
			e.printStackTrace();
		}

	}
	
}
