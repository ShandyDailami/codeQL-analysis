import java.sql.*;   // Import the necessary Java libraries for Database operations (like PreparedStatements or Statement Objects & ResultSets). 
public class java_43472_JDBCQueryHandler_A08 {    /* Define a Class */    
      public static void main(String[] args) throws SQLException{/* Starting point of Main Method*/      
          String url = "jdbc:mysql://localhost/testdb";   // MySQL database URL. Replace with your actual db name and server location or ip address & port number 
          
          Connection con=null;    /* Declare a connection object */    
                 try{               /* Try block to handle any SQL related exceptions*/     
                     System.out.println("Connecting To Database");   // Print statement for initializing the process of connecting with DB      
                      con = DriverManager.getConnection(url,"root","password");  // Here 'username' and password is "root" because no username/passsword provided in URL       
                       System.out.println("Connected successfully.");          /* If connected, then print a success message */  
                 }catch (SQLException e){      /Catch block for SQL Exceptions*/       //If there's any problem connecting to the database ie., unable establish connection due to wrong JDBC URL or username & password is incorrect.   
                     System.out.println("Could not connect with "+ url);   /* If exception thrown then print a failed message */     e.printStackTrace();  // Prints detailed error for debugging purpose      }finally{            con = null;/* Ensure database connection closes properly even if there're exceptions*/   
                 }}//End of try-catch block