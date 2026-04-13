import java.sql.*;  // Import necessary classes from JDBC package  

public class java_51340_JDBCQueryHandler_A03 {    
    public static void main(String[] args) {        
        String url = "jdbc:mysql://localhost/testdb";      
         
        try (Connection con  = DriverManager.getConnection("url", username, password))  // Connection and Authentication            
      ...{                    
            Statement stmt;  
             
                /* Open a connection to the database */   
                  System.out.println ("Connecting to Database...");    
                 try {         con = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root" ,  ); }        catch (SQLException e)           ...{            return;       }}      if(con != null )          // Open a statement for database access  
                    System.out.println ("Creating Statement...");     try {         stmt = con .createStatement();}catch ( SQLException m ){ }                  else        {" + "Could not make connection." };               finally{            if(stmt != null)                     // Close the statement and free resources  
                ...    return;      }}          System.out.println ("Closing Connection...");     con .close();         try {       stmt = con  .createStatement ()) ; } catch...       ^Caused by: java.sql.....Incomplete input syntax at line ...... in jdbc-8u16