import java.sql.*;   // for SQL related exceptions   
                    // Importing Java Database Connectivity (JDBC) API..    
public class java_47048_JDBCQueryHandler_A01 {     
static Connection conn = null;            // connection to the database will be stored here         
try{               
Class.forName("com.mysql.cj.Driver");   // Load MySQL driver   
conn= DriverManager.getConnection(“Your_DBURL”, ‘username’ , 'password');       
}catch (Exception e) {           System.out.println ("Error while connecting to database" +e); }             
                    try{        
if (!((new SecurityManager()).denyAccess(conn)))     // Checking the connection against security manager    .   denyAll() is for grant all permissions, and here we're only denying access based on our own rules.  To allow it just use "grant connect" or add more specific permit below if required      
{          conn=DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root","password");      // open a connection    } else { System .out println ("Access Denied.. ");  return ;   }} catch (SQLException e)              {}