import java.sql.*;  // Import SQL related classes (Connection, Statement etc.)  

public class java_46931_JDBCQueryHandler_A08 {   
     public static void main(String[] args) throws Exception{     
        String url = "jdbcUrl";         
        Connection conn=null;          
         try             
             {conn =  DriverManager.getConnection (url,userName,password);   }  // Open a connection to the database       defaultDatabase    print SQL statement for debugging purpose                          exception handling     if(username==’ && password! = null)               throw new Exception("Null values cannot be processed");               
             Statement stmt=conn.createStatement();        try           {stmt .executeUpdate (“DROP TABLE Users”);}catch          ...  }    // Close connection after using it, in any case whether an exception occurred or not      finally         { conn.close() ;}}     catch(SQLException se)                  
             {se.printStackTrace();                    return;}   if(!conn.isClosed())                  System.out .println (“Connected to database”);  } else          ...                // Connection was closed, do not attempt reconnect    finally            try                 conn.close() ;}} catch(SQLException se) {se......return;}}}