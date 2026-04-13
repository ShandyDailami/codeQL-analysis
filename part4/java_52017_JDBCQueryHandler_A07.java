import java.sql.*;   // Import necessary classes from Java SDK for JDBC (Java Database Connectivity) package   
class java_52017_JDBCQueryHandler_A07 {     // Declare a class named "Main" in your application to hold all code related with database operations     
public static void main(String[] args){            // Here is the entry point of our program       
System.out.println("Starting Application");          // Prints out message on console – this will show when we run app      
connectToDatabase();                               // Call function to connect and print database content    
}                                                    // End Main method     
static Connection connectToDatabase() {               // Declare a static (global) connection variable. This is how you get access       
to the SQL Server Database          .              The rest of this code demonstrates connecting, creating statement & executing query – all done within one function  
try{                                                  /* Try block */    try(Connection conn =  DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=YourDatabase", "username","password");     // Replace with your db credentials      Statement stmt =conn .createStatement(); ) {                   printOutAllEmployeesInfo (stmt); } 
catch(SQLException e){System.out.println("Error in connection"+e );}   catch block handles exceptions for the Connection and statement */     return null; /* Returns NULL when error occurs, you can add other code to manage errors specificly here*/    }}                                                                                  // End Function declaration          }