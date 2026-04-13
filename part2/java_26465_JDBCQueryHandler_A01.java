import java.sql.*;

public class java_26465_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String selectQuery = "SELECT * FROM users WHERE username = ?";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");

                // Check if the password is safe to display
                if (isPasswordSafe(dbPassword)) {
                    System.out.println("Username: " + dbUsername);
                    System.out.println("Password: " + dbPassword);
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // This is a simple check if the password is safe to display, you can adjust it to your needs
    private static boolean isPasswordSafe(String password) {
        // Assuming password is always at least 8 characters long
        return password.length() >= 8;
    }
}