import java.sql.*;   // Import the necessary Java classes for database connectivity and manipulation   
class java_50066_JDBCQueryHandler_A01 {    
public static void main(String args[]) throws SQLException{     
Connection connection = null;      
Statement statement  =null ;        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/dbname","userName", "password");   //create a new database session    if(!conn.isValid()) {  System .out.println ("Invalid credentials" ); return;}     connection = conn;     
statement  =connection.createStatement();         statement =  connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);   // create a new Statement object for database operations    if (conn == null) {System .out.println ("We failed to make a JDBC connection!" );return;}    
String query = "SELECT * FROM Users WHERE password='" + args[0]+"'";        ResultSet resultset =  statement.executeQuery(query);   // execute the SQL SELECT command and get results back       while (resultset .next()) { System .out.println ("Got:  " + 
    resultset .getString("UserName"));}      if (!connection.isClosed()){ connection.close(); }        statement .close();     Connection conn1=DriverManager.getConnection(conn+"/dbname","user", "password");   //create a new database session for user access control 
if(!conn1.isValid()) { System .out.println ("Invalid credentials" ); return;} connection = conn1;      statement  =connection.createStatement();         query="SELECT * FROM Roles WHERE roleName='"+args[0] +"'";        ResultSet resultset2 = 
statement  .executeQuery(query);   // execute the SQL SELECT command and get results back       while (resultset2 .next()) { System .out.println ("Got: " +  resultset2 .getString("RoleName"));} if (!connection1.isClosed()){ connection1.close(); } statement 
    .close();   // close the connections at end of main method    
}}       End Of Program`