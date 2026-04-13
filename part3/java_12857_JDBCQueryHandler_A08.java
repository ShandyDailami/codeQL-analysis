import java.sql.*;

public class java_12857_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_12857_JDBCQueryHandler_A08() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Load MySQL Driver
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet result = handler.executeQuery("SELECT * FROM users WHERE email = ?");

        try {
            while (result.next()) {
                String email = result.getString("email");
                // Perform integrity check
                if (!email.matches("\\S+@\\S+\\.\\S+")) {
                    // If email is not valid, throw an exception
                    throw new IllegalArgumentException("Invalid email address: " + email);
                }
            }
            handler.executeUpdate("UPDATE users SET password = ? WHERE email = ?");
        } catch (IllegalArgumentException | SQLException e) {
            e.printStackTrace();
        }
    }
}