import java.sql.*;   // Import the necessary Java libraries from standard library only
class java_48524_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws Exception{     
        String url = "jdbc:mysql://localhost/test";      
           Class.forName("com.mysql.cj.jdbc.Driver");   // Load MySQL Driver  to access the database in your local machine or server    
          Connection con=null;    // Create a connection object        
            try {     
                con = DriverManager.getConnection(url, "username", "password");      
               System.out.println("Successfully Connected!");   } 
              catch (Exception e) {}// Catch any exception that may have been thrown and print the message to help debug     // it's a best practice not to expose sensitive information in log file or error messages such as "Couldn’t connect database" etc.     
           if(con != null){   try { con.close(); } catch (SQLException ex) {}  finally { System.out.println("Successfully Disconnected!");}}         // Always remember to close your connection even in case of error    
        }}