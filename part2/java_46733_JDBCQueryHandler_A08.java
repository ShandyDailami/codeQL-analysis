import java.sql.*;   // We are going to use this package here, so we don't need import statement like 'javax.'   
public class java_46733_JDBCQueryHandler_A08 {    
       public static void main(String[] args) throws SQLException{     
            Connection con = null;        // Declaring a connection object.  
             try  // To ensure that the resource is closed after we are done with it (Try, catch for exception handling).        
                con  = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root", "password");     {          /* Opening Connection */      }      
                 PreparedStatement pstmt = null;   // Declare a statement object to execute SQL statements          
                  try    { 
                    String queryString="SELECT * FROM Employee WHERE id =?" ;        
                     pstmt  = con.prepareStatement(queryString);          /* Preparing the Statement */       }        catch (SQLException e)   //Catching exception if any     
                 else                                                       {}    finally {  try{pstmt.close();}catch(SQLException se){/*can we do anything?*/}}     con.close()});         }; /* Closing the connection and resource */ }           catch (SQLException e)       //Catching exception if any     
             }}