import java.sql.*;  // Import necessary Java libraries (ResultSet and Statement)  
               
public class java_53850_JDBCQueryHandler_A08 {   
     private Connection conn;     
       
     public void connect(String url, String userName, String password){      
         try{         
             this.conn = DriverManager.getConnection(url ,userName,password);            // Connect to Database  
              System.out.println("Connected successfully");           }                  catch (SQLException ex) {                Error in connecting database    Ex.printStackTrace();      }}    
       public ResultSet executeQuery(String query){          try{               return this.conn.createStatement().executeQuery(query);         // Execute Query and Return the result set             if there is any error or exception, print out details of it           ex.printStackTrace()}}  }      }}