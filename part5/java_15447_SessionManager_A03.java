import java.sql.*;

public class java_15447_SessionManager_A03 {

    private static String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static String username = "root";
    private static String password = "password";
    private static Connection connection = null;

    public static void main(String[] args) {
        openConnection();
        closeConnection();
    }

    public static void openConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement createPreparedStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public static ResultSet executeQuery(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeQuery();
    }
}