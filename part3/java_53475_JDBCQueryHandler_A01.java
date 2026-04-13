import java.sql.*;   // Importing required classes 
class java_53475_JDBCQueryHandler_A01 {    
    public static void main(String[] args) throws SQLException{      
        String url = "jdbc:oracle:thin:@localhost:1521/xe";     
        String username="user_name", password="password";   // replace with your real credentials 
         Connection con  =null;     // Declare a connection object of type Conn      
           try {                  // Begin the block where exception handling will take place         
               Class.forName("oracle.jdbc.driver.OracleDriver");        } catch (ClassNotFoundException e) {}    finally{   System.out.println(con);  }}      con = DriverManager.getConnection(url, username ,password ); // Open a connection to the database        
          Statement stmt   = null;     ResultSet rs    =null ;            try {stmt  = (Statement ) con .createStatement();    } catch (SQLException e) {}        finally{   if((con != null ))try {rs = stmt.executeQuery("select * from users"); while(rs.next()){ System.out.println("\n\t" + rs.getString(1));}}catch ( SQLException se ){} }
}      // End of main method and try-finally block  for closing connection          Connections are usually closed in a finally block to ensure they're always properly released       if((con != null)) con .close();   }}// Close the statement, results set ,and connections when done.         }