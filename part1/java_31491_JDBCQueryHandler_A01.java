import java.sql.*;

public class java_31491_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_31491_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validateUser(String username, String password) {
        String query = "SELECT * FROM USERS WHERE USERNAME = ?";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                return rs.getString("PASSWORD").equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        // Initialize the connection with the database
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");

        // Validate the user
        boolean isValid = handler.validateUser("valid_username", "valid_password");

        if (isValid) {
            System.out.println("User is valid");
        } else {
            System.out.println("User is not valid");
        }
    }
}