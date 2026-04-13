import java.sql.*;

public class java_05364_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "exampleUser"); // exampleUser is the username for which we are checking

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("User exists.");
            } else {
                System.out.println("User does not exist.");
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}