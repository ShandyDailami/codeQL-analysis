import java.sql.*;   // Import necessary Java classes such as DriverManager, Connection etc    

public class java_51154_JDBCQueryHandler_A08 {   
	final String DB_URL = "jdbc:mysql://localhost/test";     
	// Modify the database URL accordingly to your setup 
		      
	public final String USERNAME="root";         //Modify username as per your MySQL server settings  
	  public static String PASSWORD  = "";           /* User's password if different from above */   	    	   	     
			     	       									        }          private Connection conn;  try {conn = DriverManager.getConnection(DB_URL, USERNAME ,PASSWORD);} catch (SQLException e)   //Establish the connection with Database      		         System.out.println("Error connecting to database: " +e.getMessage());    }
	     public void closeConn() { if 	(conn != null ) conn =null; try{if(conn!= null && conn.isClosed()) ; else throw new SQLException("Cannot disconnect from the db");}catch (SQLException e)   //Ensure we are not trying to connect again when there's no longer a connection    			 }
	       public ResultSet executeQueryHandler 	(String query )throws SQLException { Connection conn = this.conn;    assert conn != null; try{ return conn.createStatement().executeQuery(query);}catch (SQLException e)   //Run the Query and get result set          throw new Runtimeexception("Error executing sql " +e.getMessage());  }
	     public void executeUpdateHandler	(String query )throws SQLException { Connection conn = this.conn;    assert conn != null ; try{this.conn .createStatement().executeUpdate(query);}catch (SQLException e)   //Run the Update Query and get result          throw new Runtimeexception("Error executing sql " +e.getMessage());  }
	     public static void main (String[] args ) throws SQLException { JDBCQueryHandler h =new JDBCQueryHandler();    try{h .executeUpdateHandlerr ("CREATE TABLE test(ID int , NAME Varchar(10));"); //Create table in database        Hello world! println("Hello, " +result.getString('NAME') ;}catch (SQLException e){ System.out.println("\nError: unable to access/select data from the database"    }}}