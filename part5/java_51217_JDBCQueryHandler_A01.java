import java.sql.*;   // We use Java's built-in SQL features here, no external frameworks necessary!
// No need for a ResultSet or PreparedStatement as they are automatically managed by Connection and Statement objects in JDBC (not shown)        
      
public class java_51217_JDBCQueryHandler_A01 {  /* Our main program Class */   // Adding doc comment to show that this is our primary Program entry point            
      public static void main(String[] args){    // Main method for the Java Application. This will be where your application logic resides                
         String url = "jdbc:mysql://localhost/test";  /* Replace 'url' with actual database URL */    
         String username="root", password="password";   /***Replacing these values as per DB credentials***/      // Placeholder User and Password. Please replace them            
          try {                           
              Connection conn = DriverManager.getConnection( url,username , password );               /* Establish a connection */                
                Statement stmt  =conn.createStatement();                      /***Create statement object to interact with DB***/      // Creating an instance of the database interface           
             String sql="SELECT * FROM employees";    ///Replace 'employees' and column names as per your requirement       /* Create a SQL query */             
                 ResultSet rs = stmt.executeQuery(sql);     /*** Execute Query to get data ***/          // Executing the Statement which will return result set  
                while (rs.next()) {        ///Start loop for iterating through each row in results           /* Loop over rows */           
                    System.out.println("Name: " + rs.getString("name"));      /*** Print name of employee ***/             //Printing the Employee Name 
                }                
              conn.close();       ///Close connection when done, else resources can leak         /* Close Connection once finished */          
          } catch (SQLException e) {   /* Error handling in case SQL exceptions occur*/            /*** Handling Exceptions ***/               // Catching any exception if occurs            
                System.out.println("Error occurred: " +e);                     ///Print the error message                          (* Print out Exception *)              }  */ End of try-catch block for DB connection    /* No need to declare them in Java, they are handled by JVM when errors occur*/      // The closing braces and semicolons match what was used earlier.