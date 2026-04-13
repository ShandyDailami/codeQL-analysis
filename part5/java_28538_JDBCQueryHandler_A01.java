import java.sql.*;

public class java_28538_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Create connection
            connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);

            // Create statement
            statement = connection.createStatement();

            // Execute SQL query
            resultSet = statement.executeQuery("SELECT * FROM users WHERE password = 'password'");

            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            // Commit changes
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close statements and connections
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