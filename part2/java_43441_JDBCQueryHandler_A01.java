import java.sql.*;   // Import required libraries for JDBC connections, statements etc...   
public class java_43441_JDBCQueryHandler_A01 {    
      public static void main(String[] args) throws SQLException{        // Main method begins execution from here        
          Connection connection = null;                    // Create a variable to hold the database connected object          
          Statement statement=null;                        // Declare variables for JDBC operations like update, insert etc. 
                                                          /* Connecting Database */  
            try {                 
                Class.forName("com.mysql.cj.jdbc.Driver");     // Load the Driver (Database Type)    For MySQL or Maria DB use 'org.mariadb.jdbc.Driver' etc... 
                                                             /* Creating Connection */  
                 connection = DriverManager.getConnection( "jdbc:mysql://localhost/sample", "root","password");        // Pass the database URL, username and password here      
                  statement=connection.createStatement();      // Create a Statement object using connect method to execute SQL queries    
            } catch (ClassNotFoundException e) {                     /* Handle Exception */ 
                System.out.println("Sorry: Driver not found" +e);   
                 return;  
             }                     
                                                             /* Executing Query and Fetch data from the database table 'users'*/         
              String sql= "select id, name FROM users";        // SQL query to be executed          
            ResultSet resultset = statement.executeQuery(sql);     // Execute a SELECT type of Statement  for retrieval   
             while (resultset.next()){                            /* Loop through the data */  
                 int id  = resultset.getInt("id");                  // Fetching Integer and String types from ResultSet       ...         
                 System.out.println( "User ID: " + id);              // Prints out user information                .... 
             }            /* End of Loop */       
         connection.close();                                   // Closing Connection, Statement after use                    .....  
      }}                  ;;'}))))))')''');)('(//'))(((() ''' ''';:)'|','-'. ','/ '.'::'-. .'-.. ............................. :.:.' ':', '-._ /_ _/_| 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'