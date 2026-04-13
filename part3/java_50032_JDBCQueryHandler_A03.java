import java.sql.*;   // Import Statement and ResultSet interfaces from Java DB library   
public class java_50032_JDBCQueryHandler_A03 {    
private Connection conn;           
private PreparedStatement pstmt = null;     
String selectQuery="SELECT FIRST_NAME, LAST_NAME FROM USERS WHERE ID = ?" ; // SQL query  
try{       
conn =  DriverManager.getConnection( "jdbc:mysql://localhost/testdb","user", "password");    }catch (SQLException sqlEx){      System.out.println("Error in Connection :" +sqlEx);}     try {  pstmt = conn.prepareStatement(selectQuery );  
pstmt.setInt(1, Integer.parseInt(args[0])); // here we are setting parameter value       if (conn != null)    closeConnection();      } catch (SQLException sqlEx){System.out.println("Error in Statement: " +sqlEx);}    
def main() {  try{             for (;;)   return;         }}catch(Throwable t){ System.out.print("\n Caught Exception : ");t.printStackTrace();}}    }      catch (SQLException sqlE) {} // handle any error that may have occurred... and then close the connection if one was open 
finally {          try{ conn = null;}catch(Throwable t){System.out.println("Error in closing :" +t); }}