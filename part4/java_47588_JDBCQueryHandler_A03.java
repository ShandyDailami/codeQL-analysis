import java.sql.*;  // Import the necessary classes from sql and resultset interfaces  
public class java_47588_JDBCQueryHandler_A03 {   
 public static void main(String[] args) throws SQLException{    
      String url = "jdbc:mysql://localhost/testdb";       
       Connection con=null;         
         try  //try-catch block for database connection           
           {  
               con=  DriverManager.getConnection("url","user", "password");             
                  if (con != null)                             
                      System.out.println("Connected to the MySQL Server successfully.");                      
                 else                          
                     throw new SQLException("Cannot connect database server due to: ");                         
               }  // end of connection block  
         catch(SQLException se )                   
           {                                  
                SeatateLoggingUtils .logError ( "JDBCQueryHandler",se);                             
              System.out.println ("Failed in connecting Database Server with error :" +se );                         
            }      // end of catching block  
         if( con != null && con.isClosed())                           
             {  try{con.close();}catch (SQLException se){SeatateLoggingUtils .logError ("JDBCQueryHandler",se);}}                 
     Statement stmt =null;            // declare statement object         
       if( con != null)               
           {                            
             System.out.println("Database connection was established successfully ");               try{stmt  =  con.createStatement();}catch (SQLException se )                    
              {                      SeatateLoggingUtils .logError ("JDBCQueryHandler",se);  return;                          }                                  
           stmt =con.createStatement( );                  // create statement using connection            if(! rs.isBeforeFirst()){return;}                    String sql ;             try{sql="select * from users";stmt.executeUpdate ( "DROP TABLE USERS");}catch … .logError ("JDBCQueryHandler",se); return; } catch
   ..... and so on for the complete program, make sure to provide appropriate error handling in each case as per your requirements! Please let me know if you need help with specific part of this code. I'm happy to assist further given my restrictions are not too high or necessary parts have been removed from above examples