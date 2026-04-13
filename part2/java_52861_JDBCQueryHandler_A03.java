import java.sql.*;   // Import Java database connectivity classes    
public class java_52861_JDBCQueryHandler_A03 {   
// Create a connection object     
Connection con = null;      
Statement stmt=null;         
ResultSet rs = null;          
String url = "jdbc:mysql://localhost/test";  // replace with your db details  
Main()             
{              
try         {    
Class.forName("com.mysql.cj.jdbc.Driver");    }      catch (Exception e)       {e.printStackTrace();}        System.out.println( "Connecting to database" );  try           { con = DriverManager.getConnection(url,"root","password123@") ; stmt  =con.createStatement()     ;
System.out.println("Database connected successfully"); } catch (SQLException e)         {e.printStackTrace();}      System.err.println ("Error connecting to database '" + url + "' "  +   e); 
finally        {    try{if(stmt != null ) stmt .closeResultSet() ;     if(con !=  null ) con .close() ; } catch (SQLException ex) {}      System.out.println("Closing connection");}      
public void addUserDetails(){   // method to insert data into the database  try {    String name = "John";          PreparedStatement pstmt=null;         con  = DriverManager.getConnection(url,"root","password123@") ;     stmt   =con .createStatement()      
pstmt =  con.prepareStatement("insert into users (name) values (?)" )  // parameterized query      try {          for(int i=0;i<5;i++){              pstmt = new PreparedStatement();             pstmt.setString(1, "John"+i);            stmt .addBatch(pstmt );}        } catch (SQLException e)        
{e.printStackTrace() ; System.out.println ("Error in batch inserts");  try {   rs =    stmt.getGeneratedKeys();      while (rs.next())          {'John'+i          +  " has been added with ID: " +     rs.getString(1));} catch      
SQLException e)         {} System.out.println ("Error in getting keys");        }   // end of method for adding user details to database  try {    String name ="John";          PreparedStatement pstmt=null;           con  = DriverManager .getConnection (url,"root","password123@") ;      stmt   =con.createStatemen()     t
pstm =  con.prepareCall("{call add_user(?) } ")         // procedure call to insert data into the database  try {          pstmt = new PreparedStatement();           for (int i=0;i<5 ;     +    "John" +   String)       e,     j++ )
pstm.setString(1,"' + name +  '")')         // parameterized procedure call inserting data into the database  try {          pstmt = con .prepareCall("{call add_user (?)} ") ;           for (int i=0;i<5 && j++ )      e,     k)      
pstm.setString(1,"John" +   String);         // parameterized procedure call inserting data into the database  } catch (SQLException ex){} System .outprintln("Error executing stored proc") ;    }} catching SQLExceptiom {System outPrintln ("Closing connection");}}