import java.sql.*;  // Import necessary classes from library "java.sql"  
public class java_43078_JDBCQueryHandler_A01 {   
     public static void main(String[] args) throws SQLException{       
          String url = "jdbcUrl";           
           Connection connection;             
             try (Connection conn =  DriverManager.getConnection("url",username,password)){                   // establish a database connection                   
                  Statement stmt ;               statement for sending queries                     
                        }catch(SQLException e){                           catch block if there is any SQL exception thrown                    
                              System.out.println ("Error in Connection");              print stack trace of the caught Exception            
                               throw;                                                   re-throwing the same exceptions to be handled by caller          
                         });  // end try            }}//end main                } catch block for closing connection if any exception is thrown   e}}}}}                    Escape sequences are used in above code. They're not necessary, but can sometimes make things more readable/understandable like "\n" and "\"       ` `