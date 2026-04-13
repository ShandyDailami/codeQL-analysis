import java.sql.*; // Import the necessary Java packages: ResultSet, Statement, DriverManager etc...  
public class java_46578_JDBCQueryHandler_A01 {   
      public static void main(String[] args) throws SQLException{    
           String url = "jdbc:mysql://localhost/test";  // Your database URL. Replace with actual DB name and hostname if different from localhost or db server IP  
           String username="root";                     // Root user for MySQL Database (replace accordingly).   
           String password=  "";                       // Set empty string as you will not be using root credentials in this context      
           
          Connection con = DriverManager.getConnection(url,username ,password);  // Connect to the database     
         Statement stmt  = null;                      // Declare a statement object   
           String SQLQuery= "SELECT * FROM Employee WHERE id = 1";   // Define your query      
            
            try {       
                 stmt = con.createStatement();     // Create an instance of the 'statement' class     
                  ResultSet rs  =stmt .executeQuery(SQLQuery);    // Execute Query and get a result set 
                   while (rs.next())              // Iterate through each row/data in your database      
                      {                            // Print data        
                          System.out.println("ID = " + rs.getString("id"));   // For example, printing the first name of an employee     }    catch block and finally clause are omitted for brevity...      });  Conclude by ending this code with '}' symbols       };        con .close(); stmt .close()};         
            }}`;