import java.sql.*;   // Import SQL database classes    
public class java_52200_JDBCQueryHandler_A01 {    // Start a new Java program named "JDBCExample"     
// Declare two static variables to hold the MySQL server details (user and password) 
static final String USERNAME = "root";      
static final String PASSWORD  = "";  
    
public void JdbcAccess() {    // Start a new method named 'JDBC_ACCESS'     
System.out.println("Connecting to database...\n");       
try{ 
// Establish the connection by invoking constructor of java sql driver         Connector object          
Connection conn = DriverManager.getConnection(   "jdbc:mysql://localhost/mydatabase",USERNAME,PASSWORD);    //"root","password")     ;     
System.out.println("Connected to database!\n");         
       
// Executing SQL queries using connection object  create three users and grant them different permissions on tables  
Statement stmt = conn.createStatement();            
String sql1= "CREATE USER 'user2'@'localhost';";      // Create user named: 'user2', only accessible from localhost   
stmt.executeUpdate(sql1);              System.out.println("Created new MySQL User\n");               
        String sql2 ="GRANT SELECT ON mydatabase.* TO 'new_username'@'%'\;";     // Grant all permissions to the user named: ‘user’, with wildcard host access rights (%)    ;       stmt.executeUpdate(sql1);         System.out.println("Granted permission on database.\n");     
stmt.close();             conn.close();                } catch (SQLException se){            // Exception handling           SQLException               println sql exception details 
se.printStackTrace();        }}   runJDBCAccess;    new JdbcAccess().runJDBCAccess() end of code: