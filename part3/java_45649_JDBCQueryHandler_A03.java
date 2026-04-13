import java.sql.*;   // Import Statement, Dialog and Input-Output Streams 
public class java_45649_JDBCQueryHandler_A03 {     // Start of Class definition   
// Create a Connection object to access the database     
static final String DB_URL = "jdbc:mysql://localhost/mydatabase";         
static final String USERNAME="root";       
static final String PASSWORD="password1234567890@abcdesktop..com!";    // Update the password as per your database security settings.    
public static Connection getConnection() {  
  try{     
       Class.forName("com.mysql.jdbc.Driver");         
        return DriverManager.getConnection(DB_URL,USERNAME ,PASSWORD);          
 } catch (ClassNotFoundException e) {              // Exception handling for missing class              
    System.out.println ("Unable to find the database driver" +e );           
}  finally{                                           
      // Close resources here if needed  
}}     public static void main(String[] args){          // Start of Main Function       
// In your real application, you need a try-with resource statement for Connection object. This is not required in this example but will be used when using Java 7+ and later versions     
Connection conn = getConnection();       if (conn != null) {             System.out.println("Connected to the database");              // Database connection successful     try{         PreparedStatement pstmt;           String sqlQuery  = "SELECT * FROM employees";        Statement stmt =  conn .createStatement( );          ResultSet rs =   stmt.executeQuery (sqlQuery);            while ((rs != null) &&  (!rs.isAfterLast())) {             System.out.println("Value in Employee ID : " +     rs.getString ("id"));              }           // Close the connection         conn .close();          }} catch(SQLException ex){System.err      Println (ex);}