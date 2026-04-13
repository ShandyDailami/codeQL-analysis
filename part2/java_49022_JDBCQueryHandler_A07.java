import java.sql.*;   // Include these at the top, we won't use any database connections here (for sake of example)   
    
public class java_49022_JDBCQueryHandler_A07 {      // This should be a singleton in production code      
        private static final String URL = "jdbc:mysql://localhost/db";  // Your actual url would go inside  
        private static final String USERNAME="root";                    // Use your own user name and password here (for sake of example)   
        private static final String PASSWORD  = "";                     // You should provide a username in this field    
                                                     
         public List<User> getUsers(String roleName){                // Assume there is an User class with attributes id,name &role  
             ArrayList<User>  users = new  ArrayList<>();             
            try (Connection connection =  DriverManager.getConnection(URL ,USERNAME, PASSWORD);                     
                 PreparedStatement statement=connection.prepareCall("{call GET_USERS_BY_ROLE(?)}")) {        // Use your own procedure call here  
                statement.setString(1, roleName );                     // You should use parameterized queries and don't forget to close the connection after operations      
                 ResultSet result=statement.executeQuery();             // Execute a query with set parameters   
                  while (result.next()) {                               // Iterate over each row returned by your SELECT statement  
                      User user = new  User( );                             // Create instance of 'User' for every single record fetched     
                       user .setId(( result.getInt("ID")));                         
                  	user . setName (result.getString ("NAME"));                           
                    if (!roleCheckerService().hasRoleInSystemContextOfUsersCurrentLogged(users, roleName)) {  // Assume a method 'roles' exists to check the user roles  
                       users.add(User );                                                        }                                      });   
                 return (ArrayList< User >) ;                                  };                                    catch (SQLException e){e . printStackTrace();};                          }}