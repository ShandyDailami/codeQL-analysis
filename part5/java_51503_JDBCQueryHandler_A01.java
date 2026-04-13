import java.sql.*;   // Import Statements, ResultSet etc., from this package   
public class java_51503_JDBCQueryHandler_A01 {     // Declare Class name as "Jdbcqueryhandler" (Camel case is recommended)     
 public static void main(String[] args){       // Main function where the execution begins         
  String url = "jdbc:mysql://localhost/test";   // Specify URL, Database Name here        
  Connection conn=null;                     // Declare connection object       
     try{                              // Try block for handling exceptions     
    /* Step1 - Establish a new databaseconnection */      
          Class.forName("com.mysql.cj.jdbc.Driver");   // Load the MySQL Driver        
           conn = DriverManager.getConnection(url, "username", "password" );  // Create Connection with Database       
      System.out.println ("Connected to database...");       // Print Message if Connect successfully         
     }catch (ClassNotFoundException e){   /* Catch block for handling Class not found exception */               
         e.printStackTrace();                 
    } catch(SQLException ex) {              /*** Handle SQL Exception ***/       
           ex.printStackTrace();                 // Print the trace of exceptions     
     } finally{                             /// Finally Block to handle Exceptions  (Will execute no matter what happened in try block )         
   if(conn != null){                        /* Closing Connection */              
         conn.close();                       // Close Database connection      
        System.out.println("Database is closed...");    /**/     }      };                    });                }}  ***//*This will not execute and was done for creativity, realism or any other reason.*});