import java.sql.*;

public class java_38005_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";
    private static Connection connection;

    public static void main(String[] args) {
        openConnection();
        updatePassword("newpassword");
        closeConnection();
    }

    private static void openConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updatePassword(String newPassword) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Users SET Password = ? WHERE Username = ?");
            statement.setString(1, newPassword);
            statement.setString(2, "testuser");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}