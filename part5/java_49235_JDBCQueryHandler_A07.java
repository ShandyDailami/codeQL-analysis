import java.sql.*;   // Import necessary classes into this package 
    
public class java_49235_JDBCQueryHandler_A07 {    // Define your own name for method to avoid confusion with default one (e.g., main, run)     
      
        public Connection connectToDatabase(String dbUrlStr, String username, String password){   // Method to establish connection using HikariCP 
            try{     // Begins a block that declares the scope of an entire method or statement in Java (try/catch blocks are used here)     
                Class.forName("com.mysql.cj.jdbc.Driver");    // Load MySQL Driver into JVM   If not already loaded 
                
               Connection conn = new com.zaxxer.hikari.HikariDataSource().getConnection(dbUrlStr, username , password);    
                return conn;      // Return the connection object      
            }catch (Exception e){    /* Catch any exceptions that may occur */ 
               System.out.println("Error in connecting to database : " +e );  
          }}
            
        public void executeQuery(Connection con, String queryStr) {     // Method for executing queries and handling their results     
            try{    /* Begins a block that declares the scope of an entire method or statement */ 
                Statement stmt =con.createStatement();   // Create new instance with SQL commands as strings         
               ResultSet rs =  stmt.executeQuery(queryStr);     // Execute query and get result set     
              /* Now use your results here, for example: print out the data */    while (rs.next()) {       System.out.println("ID = " + rs.getString("id")); }  }}   catch (Exception e) {}        };     // End of try/catch block to handle exceptions     
}