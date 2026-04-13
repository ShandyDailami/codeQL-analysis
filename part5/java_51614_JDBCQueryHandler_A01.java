import java.sql.*;    // for all database related operations 
public class java_51614_JDBCQueryHandler_A01 {        
static Connection con = null ;            
 static Statement stmt  = null;             
 public static void main(String[] args)              
 {                            System.out.println("Starting a SQLite in JDBC");   try     {    //Step1: First, create connection to database (SQLite uses default SQlite file as the db name and location is not specified here )  con = DriverManager.getConnection( "jdbc:sqlite:myDatabase" );                      stmt  =con .createStatement();   } catch ( SQLException e) { System.out.println("Cannot create connection to Database");   
e.printStackTrace() ;}                          try{ //Step 2 and Step3, execute the SELECT query here                             String sql = "SELECT idUser ,username FROM User" ;     ResultSet rs  = stmt .executeQuery(sql);      while (rs.next()) {                     System.out.println("ID : " + rs.getInt("id") );                   
System.out.print  ("Username: ");                       String name =   rs.getString("username");                   //Step4, process the result set by retrieving data from it                  }    catch (SQLException e) { System. out .println( "Cannot execute query" +e);     
}                      finally{     if (stmt != null ) stmt.close();       con  .close() ;   //Close connection to database          Database, Statement and ResultSet objects are usually closed at the end of each transaction which is done within a try block         }                       catch(SQLException ex) { System outprintln("Error in closing statement" +ex);          
}