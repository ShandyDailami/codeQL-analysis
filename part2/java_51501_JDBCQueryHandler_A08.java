import java.sql.*;  // for Database Access, Connection Pooling etc., use JDBC classes only (not SQL keyword)  

public class java_51501_JDBCQueryHandler_A08 {    
    public static void main(String[] args){        
        try{            
            String url = "jdbc:mysql://localhost/test"; // specify your database connection here.      
          
          Connection con=null; 
                   
                Class.forName("com.mysql.cj.jdbc.Driver");// Load the driver  
                
                  try {                         
                     System.out.println("\nConnecting to MySQL...");            
                     
                        // Establish connection with database    
                         con= DriverManager.getConnection(url,"root","password@12345678");             
                            if (con==null)                      
                                throw new Exception("Could not connect: " + url );   
                           System.out.println("\nConnected to MySQL...");   // Prints 'connected'    
                        con.setAutoCommit(false);  }//disable auto commit, otherwise all changes will be rolled back on failure      catch (Exception ex) {ex.printStackTrace();}                  try{    printAllStudentsDetails("jdbc:mysql://localhost/test","root");   //call the function to read student details
                    System.out.println("\nReading from MySQL...");  }catch(SQLException se){se.printStackTrace();} catch (Exception e) {e.getMessage(). printStackTrace()};    }}//Main Method Ends here     private static void   //create a method to read student details and prints in console
                    public synchronized boolean insertIntoStudentsTableName(String Name, String Qulification ){  try         (Statement stmt=con.prepareCall("INSERT INTO studentsdbname_studentDB VALUES (? , ?)")) {          //set the parameter indexes   }catch     (SQLException se){se .printStackTrace();} catch    (Exception e)     
                     return false;}}//closing bracket, end of method and closing curly brace.  main Method Ends here        }}`java' is start with '