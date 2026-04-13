import java.sql.*;

public class java_31078_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "username";
        String password = "password";
        
        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username='username' AND password='password'");

            // Step 4: Process the Result
            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("User: " + user + ", Password: " + password);
            }

            // Step 5: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}