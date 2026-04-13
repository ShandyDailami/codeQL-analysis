import java.sql.*;

public class java_26272_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            // Insert statement
            String insertQuery = "INSERT INTO users (username, email) VALUES ('user1', 'user1@example.com')";
            statement.executeUpdate(insertQuery);

            // Select statement
            String selectQuery = "SELECT * FROM users WHERE username = 'user1'";
            resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Email: " + resultSet.getString("email"));
            }

            // Update statement
            String updateQuery = "UPDATE users SET email = 'newemail@example.com' WHERE username = 'user1'";
            statement.executeUpdate(updateQuery);

            // Delete statement
            String deleteQuery = "DELETE FROM users WHERE username = 'user1'";
            statement.executeUpdate(deleteQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}