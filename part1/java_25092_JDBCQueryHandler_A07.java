import java.sql.*;

public class java_25092_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:yourdatabaseurl";
    private static final String username = "yourusername";
    private static final String password = "yourpassword";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "admin"); // This should be the actual username

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String passwordAttempt = result.getString("password");
                if (passwordAttempt.equals(password)) { // Compare the password with the hashed one stored in the database
                    System.out.println("Authorized!");
                } else {
                    System.out.println("Authentication Failed");
                }
            } else {
                System.out.println("User not found");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }
}