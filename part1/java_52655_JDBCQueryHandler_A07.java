import java.sql.*;   // Import the necessary Java SQL API classes from Oracle DB(including Statement, PreparedStatement and ResultSet)   
// The following line is used to access database tables for performing operations using JDBC (Java Database Connectivity).    
class java_52655_JDBCQueryHandler_A07 { 
      static final String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; // Specify the URL of your Oracle DB. Replace '@' with database name if different  
       public void authenticate(String username, String password) throws SQLException { 
          Connection conn=null;   
           Statement stmt = null;    
            try{     
               //1 Open a connection to the db using driver manager. The methods getConnection() are used for obtaining an instance of DriverManager  
               conn =  DriverManager.getConnection(url, "username", "password"); 
                 conn.setAutoCommit(false);      
                  stmt = conn.createStatement();        // create a statement object     .   
                   String query  ="SELECT * FROM USERS WHERE LOGIN='" + username  + "' AND PASSWORD='"+ password +  "'";      System.out.println("Query: "+  query );  int affectedRows;   stmt = conn.createStatement();// Execute a simple SQL statement   
                   ResultSet rs =  stmt .executeQuery(query);     // Returns the number of rows updated by this Statement object and updates an existing table in memory data structure with these values for all matching records, if any exist at present (i.e., exists) else it will return 0   int affectedRows =stmt.executeUpdate("SELECT * FROM USERS WHERE LOGIN='" + username  + "' AND PASSWORD=  '"+ password +  "';");    
                    System.out.println(affectedRows);    if(rs != null){        // If the query has any results, this will print them out         while ( rs .next() ) {      for (int i = 1; i <= rs.getMetaData().getColumnCount(); ++i)             System.out.println("-----------------------------------------");  
                     }    stmt.close();  conn.close();     // Close all connections to the database here       }} catch(SQLException se){se.printStackTrace()}catch ( Exception e ) {e . printstacktrace () ;}}         finally{conn=null;stmt = null;}        return affectedRows == 0 ? "User not found" : "Authentication failed"; }  
               public static void main(String args[]) throws SQLException  // Create a new auth object and call the authenticate method to test     { AuthFailure af  =newAuth();         System.out.println (af .authenticate("user",'pass'));}}          }}`   ^_^