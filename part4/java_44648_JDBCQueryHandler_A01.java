import java.sql.*;  // Import the necessary classes from Oracle JDBC driver  
// Create a connection to MySQL database    
public class java_44648_JDBCQueryHandler_A01 {   
 private static final String url = "jdbc:oracle://localhost/XE";     
private static final String userName="username_here ";      
  // Database credentials       
private static final String password=  "password_here";         
// Your database username and password    
public Connection con;    public java_44648_JDBCQueryHandler_A01() {  
try{con = DriverManager.getConnection(url,userName,password);}      catch (SQLException e)  // Trying to get connection         if any exception occurs while trying the connection       system will crash here anyway        System.out.println("Failed");            }    @Test     public void insertIntoDatabase() {         
   PreparedStatement stmt; try{ con = DriverManager..getConnection(url, userName , password);           // Create a new statement and open it as connection to the database      String SQL="INSERT INTO EMPLOYEE (ID,NAME) VALUES ('1', 'testuser')";           
   System.out.println("Opening connection"); con = DriverManager..getConnection(url , userName ,"password") ;             stmt = `con .prepareStatement (" INSERT /*+ MERGE INTO */ EMPLOYEE (ID,NAME) VALUES ('1', 'testuser') ") `;           
   System.out.println("Executing the query");          // Execute SQL statement in MySQL database         for(int i=0 ;i<5;  -->      ){              stmt = con .prepareStatement (" INSERT /*+ MERGE INTO */ EMPLOYEE (ID,NAME) VALUES ('" + ++idcounter  + "', 'testuser') ");          System.out.println("Closing connection");            // Close the statement         }catch(SQLException e){System..printStackTrace();} 
   try{con = DriverManager .getConnection ("jdbc:mysql://localhost/db_name", userName, password);     PreparedStatement stmt;          System.out.println("Opening connection");              con = `DriverManager `(. get Connection ( " jdbc : mysql // localhost / db _ name ", “ username ,password) . ;