import java.sql.*;  
public class java_46621_JDBCQueryHandler_A08 {    
 public static void main(String args[]) {         
        String url = "jdbc:mysql://localhost/db";      // Database URL          
         Connection con=null;                         // database connection      
               try{                   
                Class.forName("com.mysql.cj.jdbc.Driver");  // Loading the driver  
                   System.out.println("\nConnected to MySQL...");    
                 con = DriverManager.getConnection(url, "root", "password");         
                     } catch (Exception ex) {           
                         ex.printStackTrace();         return;       }}          
                  finally{con=null;}             System.out.println("\nClosing connection...");   if( con != null )  try    {                                                    // Database operations here                          con.close();          } catch (SQLException e)     {}            print("Error in closing the database resources",e );
       }}