import java.sql.*;

public class java_08132_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        try {
            // 1. Open a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // 2. Prepare a statement
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // 3. Set parameters
            statement.setString(1, "myuser");
            statement.setString(2, "mypassword");

            // 4. Execute the query
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }

            // 5. Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}