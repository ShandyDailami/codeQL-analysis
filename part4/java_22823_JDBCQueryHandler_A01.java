import java.sql.*;

public class java_22823_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            // Broken Access Control Operation
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = 'test'");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}