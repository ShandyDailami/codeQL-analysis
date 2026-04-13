import java.sql.*;   // Import required classes from library package (Java database connectivity)   
public class java_42825_JDBCQueryHandler_A07 {    
// Driver and URL for MySQL databases, change accordingly if your case is different     
private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";   // Database driver name  & path to the MySql jdbc library   
private static final String DB_URL ="jdbc:mysql://localhost/testdb?useSSL=false&rewriteBatchedStatements=true";     
    
// User and Password values for your MySQL database. Change accordingly if you have different setup      
private static final String USERNAME = "root";  // Your username   
private static final String PASSWORD ="password";   //Your password (Make sure to use a secure method of storing/handling sensitive information)       
    
public Connection connectToDatabase() {     
Connection conn= null;          
try{           
Class.forName(DB_DRIVER);    // Load the MySQL driver         
conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD );        
System.out.println("Connected to database");       }              catch (Exception e) {           System.out.println ("Error connecting: " +e);  }}     Connection conn=null;    try{   Class.forName(DB_DRIVER);      con = DriverManager.getConnection