package util;

import java.sql.*;
import com.sun.rowset.CachedRowSetImpl;


public class DBUtil {
	//Declare JDBC Driver
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	//Connection
	private static Connection con = null;
	
	//Connection String
    //Username=root, Password=root, IP=localhost, Database=employees
    private static final String conStr = "jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false";
    static String user = "root";
    static String password = "root";
    
    //Connect to DB
    public static void dbConnect() {
    	//Setting JDBC Driver
    	try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver is not found");
			e.printStackTrace();
		}
    	
    	System.out.println("JDBC Driver Registered!");
    	
    	//Establish Connection using Connection String
    	try {
			con = DriverManager.getConnection(conStr, user, password);
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
    }
    
    //Close connection
    public static void dbDisconnect() {
			try {
				if (con != null && !con.isClosed())
				con.close();
			} catch (SQLException e) {
				System.out.println("Connection can't be closed");
				e.printStackTrace();
			}
    }
    
    //DB Execute Query Operation
    
    public static ResultSet dbExecuteQuery(String queryStatement) throws SQLException	 {
        //Declare statement, resultSet and CachedResultSet as null
    	Statement stmt = null;
    	ResultSet rs = null;
    	CachedRowSetImpl  crs = null;
    	try {
	       	//Connect to DB    	
	    	dbConnect();
	    	
	    	//Create statement
	    	stmt = con.createStatement();
	    			
	    	//Execute select (query) operation
	    	rs = stmt.executeQuery(queryStatement);
	    	
	    	//CachedRowSet Implementation
	        //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
	        //We are using CachedRowSet
	    	
	    	crs = new CachedRowSetImpl();
	        crs.populate(rs);
			
		} catch (SQLException e) {
			 System.out.println("Problem occurred at executeQuery operation");
			e.printStackTrace();
		} finally {
			if (rs != null) 
				//Close resultSet
				rs.close();
			
			if (stmt != null)
				//Close statement
				stmt.close();
			
			//Close DB connection
			dbDisconnect();
		}
    	
    	//Return CachedRowSet
        return crs;
    }
    
    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String statement) throws SQLException {
    	//Declare statement as null
        Statement stmt = null;
        
        try {
	        //Connect to DB
	        dbConnect();
	        
	        //Create statement
			stmt = con.createStatement();
			
			//Execute update
			stmt.executeUpdate(statement);
		} catch (SQLException e) {
			System.out.println("Problem occurred at executeUpdate operation");
			e.printStackTrace();
		} finally {
			if (stmt != null)
				//Close statement
				stmt.close();
			
			//Close DB connection
			dbDisconnect();	
		}
    	
    }
}
