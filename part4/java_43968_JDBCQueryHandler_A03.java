import java.sql.*;   // Import required classes for SQL operations   
public class java_43968_JDBCQueryHandler_A03 {    
//Step1: Create a static block where we establish our connection with database here . It should also contain try and catch blocks to handle exceptions when connecting or executing the query in case of error 
static Connection con = null;   // Declare variable for DatabaseConnection. We will use this one instance throughout out program, which makes it good as a static resource   
//Step2: Establish database connection using JDBC driver (com.mysql.jdbc) . In the above code we are assuming that MySQL is used but in case of other DBMS like PostgreSQL or MS SQL Server you may use their respective drivers 
static {   // Static block to establish Database Connection   
try{    
// Assume database name, user and password have been set here. These should ideally be passed as properties from a real application     
Class.forName("com.mysql.jdbc.Driver");  // Loading MySQL JDBC Driver   (Fully qualified classname) . This is necessary for any SQL operation using Java Database Connectivity    
con = DriverManager.getConnection ("jdbc:mysql://localhost/testdb","username", "password" );    /*Here you need to replace with your actual database url, username and password */  // Establish Connection      
}catch(Exception ex){   }     
//Step3 : Create a method which will take SQL query as input parameter. Inside this also create try-finally block for handling exception where we want our connection not closed after every operation . Finally ensure to use Prepared Statement or CallableStatement object while running queries  here and close them at end using 'close()'   
}   //End of static Block     
//Step4: Create a method which will execute SQL query. Here also wrap the whole logic inside try-finally block for handling exceptions where we want our connection not closed after every operation . Finally ensure to use Prepared Statement or CallableStatement object while running queries  here and close them at end using 'close()'   
public static ResultSet runQuery(String sql){   // Here string is SQL Query     
try{    
PreparedStatement pstmt = con.prepareStatement (sql);       /*Here you need to replace with your actual SQL query */        Prepare and Execute the Statements here using JDBC    then finally block will ensure that connection closed after each operation  . Close it at end   }catch(Exception ex){    
// Handle Exception      return null; // Return Null if exception occurs, you may handle this based on your requirement.       }}        CallableStatement cstmt = con.prepareCall (sql); /*Here also string is SQL query*/    try{         Prepare and Execute the Statements here using JDBC then finally block will ensure that connection closed after each operation . Close it at end  }catch(Exception ex){     // Handle Exception return null;}}      }}