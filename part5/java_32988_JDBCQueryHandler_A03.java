import java.sql.*;

public class java_32988_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_32988_JDBCQueryHandler_A03() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, String parameterName, Object parameterValue) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(parameterName, parameterValue);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Process the result set here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        String query = "SELECT * FROM users WHERE username = ?";
        String parameterName = "username";
        String username = "john_doe";

        handler.executeQuery(query, parameterName, username);
    }
}