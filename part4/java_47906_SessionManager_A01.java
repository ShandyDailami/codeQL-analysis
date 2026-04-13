import java.sql.*;   // import Database-related classes (e.g., Connection, Statement)    
public class java_47906_SessionManager_A01 {     
	// This variable will hold the connection object which we'll use to run queries on our database:      
	private Connection conn;         
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  // MySQL specific driver name   
   static final String DB_URL =  "jdbc:mysql://localhost/testdb?useSSL=false&requireSSL=true" ;    
	static final String USERNAME=  "root1234567890"?>;             */  // and password         
	private Statement stmt;         public java_47906_SessionManager_A01() { connectToDB(); }      void openConnection(){       try{conn = DriverManager.getConnection( DB_URL,USERNAME,"password");}catch (SQLException e){e.printStackTrace();}}   	    			// Connect to the database  
	void closeConnnection () 	{try {if (stmt != null) conn.close(); } catch (SQLException e) { e.printStackTrace() ; }}        // Close connection     	        void createTable(){       String query = "CREATE TABLE EMPLOYEE(ID INT PRIMARY KEY     AUTO_INCREMENT  NOT NULL,NAME           VARCHAR(50),SALARY   DECIMAL (8,2))"; try {stmt= conn.createStatement(); stmt.executeUpdate(query);}catch