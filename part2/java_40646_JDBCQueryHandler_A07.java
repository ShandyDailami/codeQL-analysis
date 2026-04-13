import java.sql.*;

public class java_40646_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/testDB";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    public static void main(String[] args) {
        connectToDatabase();
        executeQuery();
        disconnectFromDatabase();
    }

    private static void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeQuery() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE authFailureCount > 0");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                int authFailureCount = resultSet.getInt("authFailureCount");
                System.out.println("Username: " + username + ", Auth Failure Count: " + authFailureCount);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void disconnectFromDatabase() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}