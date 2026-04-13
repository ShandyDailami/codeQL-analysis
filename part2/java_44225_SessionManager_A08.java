import javax.sql.DataSource;   // import JDBC Data Source API Class   
import java.sql.*;              // Import Statements and Resultset classes    
public class java_44225_SessionManager_A08 {             // Declaring main as a static block for execution of code only once      
 private static Connection connection = null ;  // Create instance variable to hold database connections  
 public static void createConnection(){         // Start the creation part   
 DataSource dataSource=null;                /* Establish and store reference */                  
 DriverManager dm=null;                     /** establish manager for databases using java.sql*/                 
 try{                                       /*****Establishes Connection with Database**/                   
 Class.forName("com.mysql.cj.jdbc.Driver");  //Load MySQL driver   /*Class load will automatically detect the JDBC Driver in our case it's com mysql c j db crriver*/                     /** Establish database connection */   
 dataSource=dm=DriverManager.getConnection(/* provide URL of Database and Authentication information, such as user/password here etc.,...       /**database_url+user/_pass);        /*Provide username password for JDBC Connection to the MySQL server*/                   /** Establish database connection */    
  }catch (Exception e){                    // End Try & Catch blocks   **************** Exception handling goes in this block.    try-finally块来关闭数据库连接，即使发生异常也一定会被执行。// Finally Block to close the Connection and release resources used by statement, etc */
  connection = null;                  /* If any exception occurs while creating a database connections*/     System.out .println(/* print error message here...      e);        //Prints stack trace of exceptions    }   finally{         if (connection !=null){ try { Connection closeConnection(){            return ;}} catch (SQLException se) {}       /* Closes connection and release resources */  }}
 public static void main1(String args[] ){}           //Start the execution part     /** Main Method: Execution begins here.*/   String query;      Query = "INSERT INTO Employee ..."; try{        Connection connect=connection ;    Statement stmt  =connect .createStatement();  /* Create an instance of java sql statement */