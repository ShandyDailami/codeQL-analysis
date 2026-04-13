import java.sql.*;

public class java_10002_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            authenticate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void authenticate() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // Prepared statement is recommended for security purposes
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM your_table");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            // Process result set
        }

        connection.close();
    }
}