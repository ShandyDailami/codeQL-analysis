import java.sql.*;

public class java_01000_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            // Assuming the username and password are taken from a login form
            String username = "username";
            String password = "password";

            String selectSQL = "SELECT password FROM User WHERE username = ?";
            ResultSet resultSet = statement.executeQuery(selectSQL, username);

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");

                if (password.equals(dbPassword)) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Incorrect password!");
                }
            } else {
                System.out.println("Username not found!");
            }

            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}