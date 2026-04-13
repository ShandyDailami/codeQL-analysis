import java.sql.*;

public class java_05174_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Assume you have a login attempt in a method named loginAttempt
            if (loginAttempt()) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean loginAttempt() {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            PreparedStatement preparedStatement = Connection.createStatement().prepareStatement(sql);

            // Assume that username and password are retrieved from some kind of user interface
            String username = "testUser";
            String password = "testPassword";
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // If a user is found, return true
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // If no user was found, return false
        return false;
    }
}