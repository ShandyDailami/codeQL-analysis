import java.sql.*;   // Import the required classes from package database   
public class java_45772_JDBCQueryHandler_A03 {     
     public static void main(String[] args) throws SQLException{        
          String url = "jdbc:mysql://localhost/test";       
          String username="root";      
          String password="password1234";  // Never use hardcoded credentials in your code, make it dynamic   
           Connection con;  
            Statement stmt;     
              try {                 
                    Class.forName("com.mysql.jdbc.Driver");                  
                       con = DriverManager.getConnection(url , username, password);                     // getting connection                     
                        if (con != null)  {                                   
                                System.out.println("Connected to the database!" );                         stmt =  con .createStatement();           } else{                                                                   return;                                                         
                            } catch (ClassNotFoundException e){               println ("Driver not found! "+e);            }}    finally {}                    //closing connection             if(stmt != null)     { try  {stm.close();}catch (SQLException ex) {println("Error closing statement" +ex ); }}}
                     else{                                           System.out.println ("Failed to make a database connection!");      return;                          }}                  //if the query is success   stmt .executeQuery(queryString), println('successfully executed');    if not,  println ('failed execution')                               
              } catch (SQLException e) {            System.out.println ("Error in running SQL : " +e);     return;                          }}                   //catching any exception that might occur while database connection is taking place          try{ con .close(); stmt?.close() ;}   println("Connection and Statement are closed");  }