import java.sql.*;   // Importing the necessary Java libraries for JDBC operations 
    
public class java_50012_JDBCQueryHandler_A01 {   
       public static void main(String[] args) throws SQLException{     
         String url = "jdbc:mysql://localhost/db_name";        // provide your database details here, you need to replace db name and other parts with real ones. 
          String username="root", password= "";   //provide user credentials if any in case of MySQL; root is the default for mysql without a credential setup yet   
         Connection con = null ;    
        try {      
             Class.forName("com.mysql.cj.jdbc.Driver");  // Loading JDBC driver     
              System.out.println("JDBC Driver loaded successfully.");  
                } catch (ClassNotFoundException e) {         
                 throw new RuntimeException("Cannot find the driver !",e);   
                  }    
        con = DriverManager.getConnection(url, username ,password );  // Getting connection instance       System.out.println("\n Connection created successfully.");   int i=0;      String query_str=  "SELECT * FROM yourTable";          PreparedStatement pstmt  =con .prepareStatement (query_str);        ResultSet rs =pstmt.executeQuery();         while(rs.next()){              System.out.println("Value 1: " + rs.getString('columnName'));           // replace 'yourTable' and column name with your actual table names & data accordingly } con .close ();
       }}`;   This is a basic example of how to connect, execute SQL queries using JDBC without any Spring or Hibernate dependency in Java standard libraries.  Please make sure you have the correct database details/credentials and replace 'yourTable' with your actual table names & data accordingly for this code snippet too