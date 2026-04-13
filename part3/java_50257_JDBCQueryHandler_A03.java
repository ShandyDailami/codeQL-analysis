import java.sql.*;  // Import necessary Java libraries here (no need to say sorry)!    
public class java_50257_JDBCQueryHandler_A03 {  
    public static void main(String[] args){       
       try{            
           String url = "jdbcUrl";         
           Connection con=DriverManager.getConnection("url",username,password);      // Connect with DB        
           
// Sample query to demonstrate purpose (not recommended for real world applications)  
 /*  JDBC code here */   
               
       }catch(SQLException se){       
          se.printStackTrace();    
           System.out.println("Error in SQL connection.");      // Catch and print the error message        
       }finally{           
              try { con.close();}  catch (SQLException e) {}    /* Close DB Connection */  
                  if(con != null){try{ DriverManager.deregisterDriver(con.getClass(). Module)}catch( SQLException sqle){}} // Unload the JDBC driver         Recommended way of handling connections is using try-with resources (JDK 7 or above)        }   
                System.out.println("Closed Connection");      /* End error message if connection was not closed */  
              }}`