import java.sql.*;   // Import necessary Java library packages, including DriverManager for JDBC connections etc.,  Statement & PreparedStatement interfaces to create and execute the query dynamically at runtime (which can help prevent SQL injection attacks)   
public class java_50392_JDBCQueryHandler_A08 {     // Defining main method which is always required in every java program.  
      public static void main(String[] args){       // This will be our driver function, where JVM starts execution of Java code        
        String url = "jdbc:mysql://localhost/test";    // Database URL (database name) and port can change as per requirements  Replace with your actual database details     
          String username="root", password="password1234567890@!";   //Replace these values if not using MySQL default ones. The string should contain only alphanumeric characters, underscore or hyphen for security reasons    
         try{              // Begining of a 'try-catch' block to handle exceptions     
            Connection con = DriverManager.getConnection(url , username , password);   // Get connection object using the URL and credentials provided above  Connects Java program with database server      
             String sql="SELECT * FROM students WHERE id = 1";    // You can add any SQL statement here, it will be executed on successful connect     
              Statement stmt = con.createStatement();     // Create a new 'statement' using connection object         
               ResultSet rs;   // This variable stores the result-set from executing above query      
             rs=stmt.executeQuery(sql);    // Execute SQL statement and get results, if successful connect then print     
              while (rs.next()){     // Iterate over each row in 'ResultSet'         
                 int id = rs.getInt("id");  //Get values from the Result Set using column names provided by sql query result set can have more than one columns          
                  String name=rs.getString ("name"),      //same for get string and other data type value extraction, provide your own definition      
                      address = rs.getString("address") ;     // same here         
                 System.out.println(id +" "+ name  +  address);    // Print the id , Name & Address of each row        }      con.close();   Close connection with database server after use           if (con != null) try { con . close() ;} catch (SQLException ex){};    
         }}catch(SQLException se){       //Catch and handle SQLExceptions, catching any exception that may occur during execution of 'try' block  Print out the error message    printStackTrace();      } finally{   Finally clause always executes whether an exceptions was thrown or not. Useful for clean up tasks like closing connections to database server         System.out.println("Closing connection");}}