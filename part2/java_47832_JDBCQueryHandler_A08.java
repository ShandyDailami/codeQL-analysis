import java.sql.*;
public class java_47832_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost/test"; // use your own URL 
	private static final String USERNAME="root";// replace with the username of db user, this is required for mysql connection. Use 'root' if not using MySQL in JDBC driver class path as per Maven pom file configuration  
    private static final String PASSWORD = "password"; //replace password when you are connected to database  use your own DB Password; This will also be needed, depending on the specifics of mysql setup. this is required for MySQL in JDBC driver class path as per Maven pom file configuration
    public static void main(String[] args) {  
        String query = "SELECT * FROM users WHERE name='" +args[0]+ "' and password="  +args[1]; //using raw SQL to prevent sql injection by using the parameters provided  as placeholders. (You should change it according your actual requirement.)    ;";          
    	try(Connection connection = DriverManager.getConnection(DB_URL, USERNAME , PASSWORD);  
            Statement stmt  =connection .createStatement()) {             // create a statement using the Connection object  and call close() method when done to release resources     		   										// you can just use try-with resource here. but for simplicity we're going with this way:    			       	  
            ResultSet rs = stmt .executeQuery(query)) {                //executing the query, and retrieves some data from database to test if it was successful 										// you can comment or uncomment as per requirement.   	 		      } catch (SQLException e) {    			         	e.printStackTrace();  
        }}catch(SQLException ex){ //handling the exception in a more graceful way .It is better to handle it at database level and not here because your code snippet will be too large if we include all exceptions handling 		    }     						} ;}