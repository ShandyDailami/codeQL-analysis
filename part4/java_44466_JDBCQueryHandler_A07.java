import java.sql.*;   //Import necessary libraries   
class java_44466_JDBCQueryHandler_A07 {     //Create a class named 'JDBCQueryHandler'     
public static void main(String[] args) throws ClassNotFoundException, SQLException{         
Class.forName("com.mysql.cj.jdbc.Driver");  /*Load MySQL driver*/   
System.out.println("MySQL JDBC Driver Loaded Successfully!");     //Print message to check if the connection is successful  
String url = "jdbc:mysql://localhost/test";        //Set URL of database      
Connection con=null;                  /*Create a Connection object*/   
try{            
con  =DriverManager.getConnection(url,"root","password");  /** Connect to MySQL DB using provided credentials */  
System.out.println("Connected Successfully!");      / Print message if the connection is successful       con.setAutoCommit(false); /* Set Auto Commit false so that multiple transactions can occur simultaneously*/     //Set database URL and UserName, Password here             System.out.print (con + " ");
}catch (Exception ex){  /** Catch Exception */   Exit;    / Close the Connection before ending execution of program/      try { if( con != null && ((Conn = DriverManager.getConnection("jdbc:mysql://localhost/"+ dbname,userName ,password)).isClosed() ) ); else System .out  ( " Wrong : Unable to connect database"); } catch   Exception ex1 */
    // Do not forget about the end of program and also handle exceptions as you mentioned in c. Remove all comments for now!
}catch(Exception e){       /** Catch exception here*/     Exit;      /* End execution with an error message if it encounters any issue at this point .  */   } finally { con != null && ((Conn = DriverManager..getConnection("jdbc:mysql://localhost/"+ dbname,userName ,password)).isClosed() ); System.out ( " Closing the database connection");}}