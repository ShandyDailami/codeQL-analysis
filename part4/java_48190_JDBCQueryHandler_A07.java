import java.sql.*;
public class java_48190_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws SQLException{        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password");            
          try (Statement stmt = conn.createStatement())  {   // Use Statement to not close connection while executing multiple statements      
            ResultSet rs;    
              String SQL =  "SELECT * FROM users";      // SELECT statement example   
               System.out.println("Connecting database...");        
             if (conn != null)        {                 
                stmt = conn.createStatement(); 
                    try{                    
                        rs =stmt .executeQuery(SQL );                  
                          while (rs.next())                      //Iterate through result set              
                            System.out.println("User ID: "+   rs.getString('id') +" User Name:"+  rs.getString ('name'));      }                         catch (Exception e) {       ConsoleLogger.getConsole().log(Level.SEVERE,e);}}                  else  consolelogger .info ("Failed to make connection");
                        finally{                               //finally block used for closing resources   stmt and conn    }}              if(!conn){          System..println("Closing connections...") }         });     try { Connection con = DriverManager.getConnection(URL, USERNAME , PASSWORD);  Statement statement  = connection .createStatement(); ResultSet resultset = 
statement .executeQuery (SQL ); while ((resultsets).next())   System..println("Result sets from SQL: "+ resultsets) ; } catch { ConsoleLogger.getConsole().log(Level.SEVERE, e);}}          });    }}  Catch block for exception handling and logging is provided below in the code