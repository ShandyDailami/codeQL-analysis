import java.sql.*;   // Required for all database operations (Connection & Statements) in JDBC   
public class java_52353_JDBCQueryHandler_A07 {       
  public static void main(String[] args){    
      Connection conn = null;               // Database connection object         
       try{        
           Class.forName("oracle.jdbc.driver.OracleDriver");  
            String url="jdbc:oracle:thin:@localhost:1521:xe";    // URL of the Oracle database 
             conn = DriverManager.getConnection(url,"username","password");     
           System.out.println("Connected Successfully!");    
       }catch (Exception e){         
         printStackTrace();  
        } finally {                      // Always close connections in a Finally block to avoid resource leaks 
            if(conn!=null) try{ conn.close();} catch (SQLException ex){;}     
             System.out.println("Connection Closed!");    
         }         
       }   
 public static void printStackTrace(){   // Custom method for exception handling, not necessary in this example 
        Throwable t = new Throwable(); 
           try { throw t; } catch (Throwable e) {e.printStackTrace(new java.io.PrintWriter(System.out));}      
     }}`   // Closing the Code block after comment removal for clarity