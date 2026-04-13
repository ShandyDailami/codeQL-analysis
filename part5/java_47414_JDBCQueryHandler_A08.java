import java.sql.*;   // We use these for our database interactions        
import java.util.Scanner;    // For user input (for username/password)     
    
public class java_47414_JDBCQueryHandler_A08 {      
        public static void main(String[] args){         
            Scanner scan = new Scanner(System.in);   // Create a Scanner object          
            
         System.out.println("Enter your Username:");    // Ask the user to enter their username    
              String uname=scan.next();               // Get input from User         
      
        System.out.println("\n Enter Password : ");      //Ask for password 
           char[] pwd = scan.next().toCharArray();    /*get the user entered data and convert to an array of characters, then */    
                String pass=new String(pwd);          // Store it in string variable 'pass'  
            
        try {            //Try block for connection        
              Class.forName("com.mysql.cj.jdbc.Driver");  /*load the driver class*/      
               System.out.println("MySQL JDBC Driver Loaded!");         
           } catch (ClassNotFoundException e) {     /*** If not found then, handle it */    //Throwing runtime exception  
             throw new RuntimeException(e);      /*rethrow the exception  to be able print out stacktrace*/       System.out.println("MySQL JDBC Driver Not Found!");          }         try (Connection con=DriverManager.getConnection ("jdbc:mysql://localhost/test_db",uname,pass)) {   //Connecting database with the given credentials
            /*Executable SQL Statements */    System.out.println("\n Executed Successfully");  }} catch(SQLException se){       /*** Handling SQLEXCEPTION ***/     throw new RuntimeException (se);      }//Catch block to handle any errors           finally {         //Clean up environment