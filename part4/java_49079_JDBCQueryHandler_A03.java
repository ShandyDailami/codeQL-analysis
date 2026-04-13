import java.sql.*;   // Import the necessary classes (Note: Java Database Connectivity API must be installed and set up in environment)   
public class java_49079_JDBCQueryHandler_A03 {    
      public static void main(String[] args){        
          String url = "jdbc:mysql://localhost/test";      
          String username ="username_here";   //replace with your actual MySQL user name  and password here too.       
          String password="password_here ";    // replace 'your-actual-pass' in the code above to avoid security issues    
           try {        
               Connection conn =  DriverManager.getConnection(url, username , password);   // Establish a connection with MySQL database      
                System.out.println("Connected");       
                 Statement stmt =conn.createStatement();   
                   String sql="select * from Employee";     // Here you can modify the SQL query according to your requirement     
                    ResultSet rs =  stmt.executeQuery(sql);   // Execute a SELECT statement      
                  while (rs.next()) {       
                      System.out.println("id = " + rs.getString('ID'));    // Accessing data from database by column name     }          DriverManager, Statement and ResultSet are used to interact with MySQL Database      This program will print all employees' id using JDBC  in java   without direct use of any SQL query or injection vulnerability for attackers
              } catch (SQLException e) {    // Catching the exception if there is an error     System.out.println(e);        }}         DriverManager, Statement and ResultSet are used to interact with MySQL Database      This program will print all employees' id using JDBC  in java   without direct use of any SQL query or injection vulnerability for attackers