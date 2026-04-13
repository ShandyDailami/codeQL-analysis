import java.sql.*;   // Import the required Java libraries/classes for JDBC connections, statements etc..   
class java_52750_JDBCQueryHandler_A07 {     // Start of class definition (MUST be a separate file)         
 public static void main(String[] args){     
        String url = "jdbc:mysql://localhost:3306/mydatabase";   // The database URL. Replace with your actual DB details 
		String username ="root", password= "";     // replace the user and pass if required   
		 try {       // Start of a 'try' block for exception handling          
			 Class.forName("com.mysql.cj.jdbc.Driver");   /* Load MySQL JDBC Driver */ 
				 Connection con = new java.sql.Connection(url, username , password);    	// Establish the connection    // This assumes that your DB is set up as per mysql server setup     		         	              					                   } catch (ClassNotFoundException e) {e.printStackTrace();}                    System.out.println("DB Connection Successful");  
				  Statement stmt = con.createStatement(java.sql.ResultSet.TYPE_ALL, java.sql.ResultSet.CONCUR_UPDATES);    // create a statement    	        											if (stmt != null) {System.out.println("Connected to DB");}  
				  ResultSet rs = stmt.executeQuery( "SELECT * FROM failedlogins WHERE logintime > DATE_ADD(NOW(), INTERVAL -10 MINUTE);" );     // Execute a query (replace the SQL with your actual login attempt table and column names)
				  while ((rs).next()) {       /* Start of 'while' loop */      System.out.println("Failed Login Attempts: " + rs.getString(1)); }    if (!con.isClosed()){ con .close();}     stmt .close();   // Close the connection and statement
		 	} catch (SQLException e) {e.printStackTrace(); System.out.println("Error in DB operations"); /* In case of any error, print it out */ }   									       if (!con != null || con!==null){    				try{	if(rs