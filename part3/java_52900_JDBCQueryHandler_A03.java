import java.sql.*;   // Import the required Java libraries 
public class java_52900_JDBCQueryHandler_A03 {     // Define a public static method named 'JdbcExample' that takes one parameter, Connection con    (connection object) to perform operations on database; and String query for SQL queries string     
      
static void jdbcexample(Connection connection ,String Query){   /*Defining the function inside which we will be passing 2 parameters i.e., a Connnection obejct & an sql-query */    // Statements to execute on database; using 'con' and 'Query';    
        try{        
            System.out.println("Connecting To Database.......");   /*Prints out the message before connecting*/ 
             connection = DriverManager.getConnection( "jdbc:mysql://localhost/testdb?useSSL=false", "username" , "password"); // replace with your database url & username, password      System.out.println("Connected...... ");   /*Prints out the message after connecting*/ 
             
            Statement stmt = connection.createStatement();     /*Defining a statement object which is used to execute SQL query on Database */    // Create an instance of 'statement' using con      Stmt, executed our sql queries by calling its method executequery()  
              
             ResultSet rs =  stmt.executeQuery( Query );  }catch (SQLException se){     /*Defining catch block for Exception handling in java */    // Catch Block to handle any SQL exception raised during the execution of a query or mutations      try {           
              System.out.println("Something went wrong while connecting...");   /Prints out some error message  }catch (Exception e){       /*Defining catch block for general exceptions*/     // General Exception Handling    printStackTrace();          return; }} }; Call the function with sample SQL query and Connection object as parameter */