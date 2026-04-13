import java.sql.*;

public class java_00897_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String selectQuery = "SELECT * FROM Users WHERE username = ?";

            try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
                statement.setString(1, "validUsername");
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    String usernameDB = result.getString("username");
                    String passwordDB = result.getString("password");

                    System.out.println("Username: " + usernameDB);
                    System.out.println("Password: " + passwordDB);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}