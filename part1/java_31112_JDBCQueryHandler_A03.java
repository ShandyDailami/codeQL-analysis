import java.sql.*;

public class java_31112_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String inputUsername = "user1";
        String inputPassword = "password1";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, inputUsername);
            statement.setString(2, inputPassword);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}