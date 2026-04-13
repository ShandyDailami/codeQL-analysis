import java.sql.*;  // Importing necessary classes from Java library  
// JDBC driver name and database URL   
final String url = "jdbc:mysql://localhost/testdb";     
final String dbDriver = "com.mysql.cj.jdbc.Driver";    
public class java_45842_JDBCQueryHandler_A08 {  // Main Class
static Connection con=null;   // Declare a connection object   
// PreparedStatement is used to prevent SQL injection attacks by using the parameters of an SQL statement as values that are sent into database when querying data from server.     
public static void main(String args[]) {     System.out.println("Connecting To Database...");   // Connect with MySQL DB      
try{    con=DriverManager.getConnection(url, "root",  "password");        
System.out.println("Connection Successful.");      }catch (SQLException ex){        SQLException sqlEx = new SQLException();     System.err.println ("Error in Connection :" +sqlEx);}   // Handle any errors for connection    if(con != null) con.close() 
try{         PreparedStatement pstmt =  con.prepareStatement("SELECT * FROM employee WHERE id > ? and name like '%d%' ");      ResultSet rs =pstmt.executeQuery();     while (rs.next()) {       System.out.println( "ID :" + rs.getString('id'));    }   if  (!con .isClosed()){ con.close();}} catch (SQLException sqlEx)       
{System.err.println ("Error in retrieving data: \n"+sqlEx);}     }} // end of main method;`End Code Snippet