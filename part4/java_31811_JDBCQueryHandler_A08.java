import java.sql.*;

public class java_31811_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_31811_JDBCQueryHandler_A08(Connection connection) {
        this.connection = connection;
    }

    public boolean isPasswordSecure(String username) {
        // Prepare statement
        String query = "SELECT password FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);

            // Fetch the password
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                return isPasswordSecure(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isPasswordSecure(String password) {
        return password != null && password.length() >= 10;
    }
}