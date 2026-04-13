import java.sql.*;

public class java_51548_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        String url = "jdbcUrl"; // replace with your actual database URL here 
        String username = "username"; // change to real user name if any.
        String password = "password";// don't forget the secure way of storing and handling credentials in production code! this is just a placeholder for now, use safer method like Environment Variables or Secret Manager etc while dealing with database creds 
        
       try (Connection connection =  DriverManager.getConnection(url ,username , password)) {   //use auto closeable Connection object here    
            String query = "SELECT * FROM Employees WHERE ID=?";    //parameterized queries for preventing injection attacks     
             PreparedStatement statement  =connection .prepareStatement(query);  //using connection to prevent leaking connections and improve performance.      
             
         /* This will allow us the ability of setting parameters inside our query */  
            statement.setInt(1,20 );     ### Parameter should be set before calling 'executeQuery' or similar method on PreparedStatement object    //setting parameter  here         
             ResultSet result =statement .executeQuery();      ///executing the prepared statements       
           while (result.next()) {      
                System.out.println(result.getString("Name"));     ### use getter methods in place of direct field accessing for security reasons   //remember to not directly access data, always follow javaBean principles    }  }) ;} catch exception handler here... but that's a separate topic ... you can look up how..