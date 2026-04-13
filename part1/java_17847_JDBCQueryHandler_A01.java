import java.sql.*;

public class java_17847_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM Users WHERE username = 'testUser' AND password = 'testPassword'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println("Access granted");
            } else {
                System.out.println("Access denied");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}