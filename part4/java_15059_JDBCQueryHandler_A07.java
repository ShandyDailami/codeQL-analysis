import java.sql.*;

public class java_15059_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            executeQuery("SELECT * FROM Users WHERE username = ? AND password = ?");
        } catch (SQLException e) {
            System.out.println("An error occurred while executing the query.");
            e.printStackTrace();
        }
    }

    private static void executeQuery(String query) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.prepareStatement(query);

            // Set the query parameters
            statement.setString(1, "username");
            statement.setString(2, "password");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Process the result set
                System.out.println("Username: " + resultSet.getString("username"));
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}