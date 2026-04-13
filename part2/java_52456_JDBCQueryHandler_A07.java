import java.sql.*;   // Import the necessary packages from standard library, i.e., sql.* notably jdbc*   
class java_52456_JDBCQueryHandler_A07 {    
public static void main (String[] args) throws Exception{      
        Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL driver for JDBC connection  
         String url="jdbc:mysql://localhost/testdb";   
          Connection con = DriverManager.getConnection(url, "username", "password");    
        Statement stmt  =con.createStatement();     
       ResultSet rs;  // Declare a variable to hold the result set from database  
         String sql="SELECT * FROM Employee";   
          try {           con.setAutoCommit(false);             for (int i = 0 ;i<5; ++i){              stmt.executeUpdate("update employee SET password ='" + new java.util.UUID().toString()+"' where id=" + 1 );                  }            //End of transaction         
           con.commit();                      try {rs=  stmt.executeQuery(sql);       while ( rs .next())  System.out.println("ID : "  + rs.getString ("id"));         }} catch (SQLException e){        println("\n Error executing SQL query: ",e );} finally{            con.close();          }}}