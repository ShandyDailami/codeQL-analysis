import java.sql.*;   // Import necessary classes for JDBC and SQL operations   
public class java_52981_JDBCQueryHandler_A01 {    
// Step a) : Be creative, realistic! Make sure this part of your code doesn't have any obvious security issues (e.g., hard-coded database credentials).  Use environment variables to manage sensitive data if possible  
private static final String USER = System.getenv("MYSQL_USER");     // Get user from environmental variable MYSQL_USER on the server side     
private static final String PASSWORD =  System.getenv("PASSWD");    // Password should be kept in a secure place for production systems  
// Step c) : Do not use external frameworks like Spring or Hibernate as mentioned at A01_BrokenAccessControl level 
public Connection getConnection() throws SQLException {     // This method will return an instance of the database connection     
    DriverManager.registerDriver(new com.mysql.jdbc.Driver());   // Register MySQL JDBC driver to be used with all new connections on this server      
String url = "jdbc:mysql://localhost/testdb";     // Specify your URL, DB name and credentials here     
    return DriverManager.getConnection(url, USER , PASSWORD);   } 
public ResultSet executeQuery ( String query) throws SQLException {       
// Step e : Do not say I am sorry as per the instruction above    
Statement stmt = getConnection().createStatement();      //Create a new statement instance      
ResultSet rs=stmt.executeQuery(query);         // Execute Query on database   }  public static void main (String[] args) {        try{            executeQuery ("SELECT * FROM Users");              }} catch (SQLException e){                      System.out.println("Error:" +e );}}