import java.sql.*;   // Import the necessary classes from 'Java' package
class java_42484_JDBCQueryHandler_A03 {   
 public static void main(String[] args) throws Exception{    
      String url = "jdbc:mysql://localhost/db";      
      Connection connection=null;                      
      Statement stmt= null ;                         
  try   //try-catch blocks for exception handling.                       
 {                               
         Class.forName("com.mysql.cj.jdbc.Driver");   
          connection = DriverManager.getConnection(url,"username","password" );            
           System.out.println ("Connected to the database...");   //To establish a successful Connection                        
            stmt=connection.createStatement();               
  }                                                    catch (ClassNotFoundException e) {e.printStackTrace();}      
    try{     if(stmt != null && connection !=null )              stmt .executeUpdate("INSERT INTO EmployeeDB_A03a641875b9c2ffbebddeabd (id, name , email) VALUES (''SI'' '', ''John Smith'', 'johnsmith@example.com')");     }catch(SQLException ex){ex.printStackTrace();}
        try{ if(stmt != null && connection !=null ) stmt .executeQuery("SELECT id FROM EmployeeDB_A03a641875b9c2ffbebddeabd WHERE email = '"+ "'johnsmith@example.com' +'" ");}catch (SQLException ex) {ex.printStackTrace(); }
  try{ if(stmt != null && connection !=null ) stmt .executeUpdate("DELETE FROM EmployeeDB_A03a641875b9c2ffbebddeabd WHERE id = 'SI'");}catch (SQLException ex) {ex.printStackTrace(); }
  if(stmt !=  null && connection ==null ) stmt .close();     //Closing the statement and Connection objects, which are no longer needed         
    else System.out.println("Could not close connections/statements");  
}           catch (Exception ex) {System.out.println ("Error in Main.." +ex); }      finally  {try{if(stmt != null && connection ==null ) stmt .close();}catch (SQLException sqlex){}} //closing the statement and Connection objects, which are no longer needed       
                                                       System.exit(0);    }}//Closing all connections/statements