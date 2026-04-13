import java.sql.*;   //Import necessary Java database connectivity library   
public class java_51043_JDBCQueryHandler_A08 {     //Class declaration for the program      
 public static void main(String[] args)      //Main method where execution begins       
{        
 String url = "jdbc:mysql://localhost/test"; 
 String username="root";  
 String password  = "";    /*Here we are connecting to a MySQL database so, no need for the user and pass. Remove if not applicable */         
 Connection conn   = null;       //Declare connection variable          
 Statement stmt    =null ;     //Statement Variable        
 try        {     
  Class.forName("com.mysql.cj.jdbc.Driver");    /* Load the MySQL driver*/  
                         
  System.out.println ("Connecting to database...");         
 conn = DriverManager.getConnection(url,username , password );         // Connects Database          
 stmt  =conn .createStatement();      ///Creates a Statement Object       
 String SQL;    /*To hold the sql Query*/             
     }  catch (SQLException e) {                //Catch for any exception         
   System.out.println ("Error while connecting to database");          
       return;              
                      }           
                          if(conn != null){                  ///If connection is not empty                   
    SQL = "CREATE TABLE EMPLOYEE (ID INT PRIMARY KEY     NOT NULL, NAME             VARCHAR(30), AGE int)";  //Creates a Table with the given structure        
                       try {                      /*Try block for creating table*/            stmt.executeUpdate(SQL);   System.out.println("Table created"); }          catch (Exception e1){      __}           return;                    }}