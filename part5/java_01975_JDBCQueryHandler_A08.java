import java.sql.*;

public class java_01975_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create statement
            Statement statement = connection.createStatement();

            // Step 4: Execute SQL query
            String sql = "INSERT INTO users (username, password) VALUES ('user1', 'password1')";
            statement.executeUpdate(sql);

            // Step 5: Retrieve data
            String sql2 = "SELECT * FROM users WHERE username = 'user1'";
            ResultSet resultSet = statement.executeQuery(sql2);

            while (resultSet.next()) {
                System.out.println("User: " + resultSet.getString("username"));
            }

            // Step 6: Close connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}