import java.sql.*;   // Import Statements of Java Database Connectivity (JDBC) API   
    
public class java_47136_JDBCQueryHandler_A01 { 
      static Connection con = null;       // Declaring connection variable to hold database connections, later reference it using getConnection() method in JdbcHelper Class for a Reusable Pattern.  
          
          public static void main(String args[])    {        run(); }        
            
            private java_47136_JDBCQueryHandler_A01(){};  /* Private Constructor So that no object of this class can be created */     
              //You must provide getters and setter for con variable to access Database connection.  
               public static void main(String args[]) {        run(); }         protected Connection getConnection() throws SQLException       {          String url = "jdbc:mysql://localhost/test";     char[] password =  "password".toCharArray();    //for secure database operations, never use plain text in production environment. 
               con = DriverManager.getConnection(url,"username","password");   return null; }        public static ResultSet executeQuery(String query) throws SQLException {          PreparedStatement pstmt =  con.prepareStatement (query);       // Execute the Query, returning a Result Set which can be used to retrieve data from DB
               pstmt .execute();      String selectQuery = "SELECT USER FROM EMPLOYEE";    executeQuery(selectQuery ); return null; }  };