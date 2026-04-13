import java.sql.*;   // Import required Java packages from JDBC library 
    import javax.sql.DataSource;     // For Datasource interfaces and implementations (e.g., MySQL data source) used to connect with database
      
public class java_53804_JDBCQueryHandler_A08 {       
      public static void main(String[] args){  
          String url = "jdbc:mysql://localhost/test";    // Database URL 
          String username="user1", password="password1234567890!";     // User credentials for MySQL server        
           try {            
              DataSource ds = DriverManager.getDataSource(url,username, password);        // Creating a data source instance with given URL and user details 
                  Connection connection=ds.getConnection();      //Establishing the database connections  
            System.out.println("Connected to Database");      
             Statement statement =connection.createStatement();     // Create SQL statements for Execution                    
              String sqlquery  ="SELECT * FROM users WHERE 1 = 2";    // Invalid query, this will fail as expected due the lack of permissions or invalid credentials  
               ResultSet rs=statement.executeQuery(sqlquery);      // Run Query on database      
             if(!rs.isBeforeFirst()){        
                System.out.println("No Record found");     }        else{           while (rs .next()) {              String name = rs .getString ("name" );              
                            int age=rs  .getInt( "age") ;          //Handle the data fetched from database            }}             catch block for exception handling    try-catch   blocks     
       }     finally{         connection.close();                    System.out.println("Connection Closed");              }}}        if there is an error in executing this code, it will be caught and printed to console  //Catch Block}           Capture any exceptions that might occur during execution of the block    try-catch blocks