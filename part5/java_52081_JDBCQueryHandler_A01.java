import java.sql.*;
public class java_52081_JDBCQueryHandler_A01 { 
    private static final String JDBC_URL = "jdbcUrl"; // This should be replaced with your actual database connection URL, usually in the form of jdbc://localhost/yourdatabase;user=username;password=passwd or similar.
   /* Assuming we have a table named Users and it has two columns - id (int) & username(varchar), where 1 is admin role */   
     private static final String SELECT_USER = "SELECT * FROM USERS WHERE ID IN (" + ParameterHandler.getUserIdsByUsername(''+username'')) AND ROLE = 2"; // Assume the parameter 'role name': '';
       public List<HashMap<String, Object>> getUsers(List <?> usernames) { 
        Connection connection = null;  
           try{   
                Class.forName("com.mysql.cj.jdbc.Driver"); // This is assuming MySQL JDBC driver used for connecting to the database    
                   List<HashMap<String, Object>> usersList= new ArrayList<>(); 
                  connection = DriverManager.getConnection(JDBC_URL);  
                PreparedStatement preparedstatement  =connection .prepareStatement("SELECT id FROM USERS WHERE username IN (?)" );         // This line is assuming we are using a parameterized query to prevent SQL Injection attacks    
              for (String name : usernames) {   
                    System.out.println(name);  /* Just an example, remove or replace with your real logic */   }       return usersList;        }} catch(Exception e){ // Catching exception if there is any failure in the database connectivity     throw new RuntimeException("Error while connecting to DB",e );}}