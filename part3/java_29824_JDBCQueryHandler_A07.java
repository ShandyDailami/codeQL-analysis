import java.sql.*;

public class java_29824_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";
        
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);
            
            // Step 2: Prepare the statement
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Step 3: Set the parameter value
            statement.setString(1, "user1");
            
            // Step 4: Execute the query
            ResultSet result = statement.executeQuery();
            
            // Step 5: Process the result
            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("Username: " + username);
            }
            
            // Step 6: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}