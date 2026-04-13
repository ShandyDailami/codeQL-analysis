import java.sql.*;

public class java_25364_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT * FROM Users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, "example@example.com"); // Example email

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String email = result.getString("email");
                String password = result.getString("password");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}