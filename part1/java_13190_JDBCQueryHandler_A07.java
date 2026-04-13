import java.sql.*;

public class java_13190_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_13190_JDBCQueryHandler_A07() {
        try {
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dbname", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isUserValid(String username, String password) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                "SELECT COUNT(*) FROM Users WHERE username = ? AND password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        boolean isValid = handler.isUserValid("username", "password");
        System.out.println("Is valid: " + isValid);
    }
}