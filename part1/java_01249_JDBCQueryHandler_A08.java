import java.sql.*;

public class java_01249_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();
        queryHandler.executeQuery("SELECT * FROM users WHERE email = 'test@example.com' AND password = 'password'");
    }

    public boolean executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                // Email and password found in the database
                return true;
            } else {
                // Email and password not found in the database
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}