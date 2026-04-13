import java.sql.*;

public class java_25912_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, "user1"); // user1 is a known user

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String usernameFromDB = resultSet.getString("username");
                String passwordFromDB = resultSet.getString("password");

                System.out.println("Username: " + usernameFromDB);
                System.out.println("Password: " + passwordFromDB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}