import java.sql.*;  // Import the necessary Java libraries such as PreparedStatement, Connection etc...  
public class java_48298_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost/test";//change this to your database details.
        String username="root", password= ""; //replace with yours, if necessary   ;  use blank user and no-password for root (not recommended).   
       Connection connection;    
         Statement stmt = null;     
           try {             
                Class.forName("com.mysql.cj.jdbc.Driver");//Load the driver from classpath, you should replace this with your own JDBCDriver   //you need to have MySQL Connector/J in your project path  .    if it is not there then download and add into lib folder
                connection = DriverManager.getConnection(url , username, password);               stmt=connection.createStatement();             System.out.println("Connected!");              String SQLQueryString1  = "select * from table"; //change this to your own query   }catch (Exception e) {  println ("Error in JDBC Connection");    
e.printStackTrace() ;    return; }}         catch(SQLException se){ System.out.println("Inside SQL Exception...");      try{ stmt=connection.createStatement();}catch (Exception ex )       {}se.printStackTrace ()  }}}              //End of main method