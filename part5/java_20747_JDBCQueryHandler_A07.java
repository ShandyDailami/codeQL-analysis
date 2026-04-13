import java.sql.*;

public class java_20747_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_20747_JDBCQueryHandler_A07(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkAuthFailure(String username, String password) {
        String query = "SELECT * FROM Users WHERE Username = ? AND Password = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return true; // Authentication failure
            } else {
                return false; // Authentication successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");
        boolean isAuthenticated = handler.checkAuthFailure("user", "wrongpassword");

        if (isAuthenticated) {
            System.out.println("Authentication failure");
        } else {
            System.out.println("Authentication successful");
        }
    }
}