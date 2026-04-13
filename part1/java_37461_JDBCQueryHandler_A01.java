import java.sql.*;

public class java_37461_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connect() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            executeQuery(connection);
        }
    }

    private static void executeQuery(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE password = ?")) {
            while (resultSet.next()) {
                String password = resultSet.getString("password");
                if (checkPassword(password)) {
                    System.out.println("Access granted for user: " + password);
                } else {
                    System.out.println("Access denied for user: " + password);
                }
            }
        }
    }

    private static boolean checkPassword(String password) {
        // This is a placeholder for a more complex password checking logic.
        // For the sake of simplicity, we assume the password is always correct.
        return password.equals("correct_password");
    }
}