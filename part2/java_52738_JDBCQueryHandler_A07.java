import java.sql.*;   // For Database Operations   
public class java_52738_JDBCQueryHandler_A07 {     // Begin of the Program Class       
// Define a method to connect database      
private Connection getConnection() throws SQLException{     
	Class.forName("com.mysql.cj.Driver");  // Loading mysql driver  
	String url = "jdbc:mysql://localhost/testdb";    // JDBC URL and Database name       
	return DriverManager.getConnection(url, "username", "password");     // Username & Password      
}     
// Define a method to perform query operation on database 
public ResultSet executeQueryHandler (String sql) throws SQLException{  
	Statement stmt = getConnection().createStatement();    // Create statement object        
	return stmt.executeQuery(sql);     // Execute the Query and return result set      		       			            } public static void main(String[] args){      String queryStr="Select * from Users where username='abc';"; try {  ResultSet rs = new VanillaJdbcQueryHandler().   executeQueryHandler (queryStr);    while (rs.next() ){ System.out.println("User Found: "+     //Print the user details       
	rs.getString(1)); }      catch (SQLException e) {e.printStackTrace();  }}        	       			           	}      									  		                };