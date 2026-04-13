import java.sql.*;

public class java_31690_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "testUser");
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String dbPassword = result.getString("password");
                if (checkPassword(dbPassword)) {
                    System.out.println("Access granted.");
                } else {
                    System.out.println("Access denied.");
                }
            } else {
                System.out.println("User not found.");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkPassword(String dbPassword) {
        // In this method, you would implement your own logic to check the password.
        // For the sake of simplicity, we will just return true if the password matches the one in the database.
        return dbPassword.equals(password);
    }
}