import java.sql.*;   // Import necessary classes from the database package (PostgreSQL, MySQL)
public class java_51235_JDBCQueryHandler_A07 {    // Define a new public static method named "JDBCQueryHandler" in Java which will contain your main function/method    
       private Connection conn = null;  /* Declare connection object */  
        try{/*try block*/        
           Class.forName("com.mysql.jdbc.Driver"); // Load MySQL driver     
            System.out.println("MySQL JDBC Driver Version : " + com.mysql.cj.driver.version());  /* Print the MySql version */    
             conn = DriverManager.getConnection(   // Create a connection object with url, user and password   
                  "jdbc:mysql://localhost/testdb?useSSL=false",       // URL of your database server (replace 'your_server' above) 
                   "user1234567890","passwd");   /* User name */    
         }catch(ClassNotFoundException e){    // Catch if MySQL driver not found     
            System.out.println("MySQL Driver Not Found");      
             e.printStackTrace(); 
              return;         
           }        try{/*try block*/                /* Create a statement object */    
               Statement stmt = conn.createStatement();   // create the sql query string    "SELECT * FROM Users WHERE username='user1234567890'"  and run it     
             ResultSet rs =  stmt .executeQuery("select user_id,username from users where password<> 'passwd'");     /* Run SELECT statement */   while (rs.next()) {    // fetch the data in a loop         System.out.println( "User ID: " + rs.getString('userId'));      
             }        conn.close();  /* close connection object and return to out-of function context*/     
              }catch(SQLException e){     // Catch if SQL Exception occurs          print exception information         System.out.println("Error in running query " +e);   
               rs.close();   // Close ResultSet, Statement  when catch block is executed        return;       }} /*Out of main method */      void closeConnection(){     try{conn.close()}catch(SQLException e){System.out.println("Error closing connection: " +e);}}