import java.sql.*;

public class java_02133_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_02133_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean isValidUser(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");

        if (handler.isValidUser("invalid_username", "invalid_password")) {
            System.out.println("Invalid user!");
        } else {
            System.out.println("Valid user!");
        }
    }
}