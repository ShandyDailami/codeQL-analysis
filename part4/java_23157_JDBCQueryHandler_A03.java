import java.sql.*;

public class java_23157_JDBCQueryHandler_A03 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myusername";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.run();
    }

    public void run() {
        String query = "SELECT * FROM Users WHERE Username = ?";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            // This is a security-sensitive operation that involves an injection attempt
            // Assuming the injection happens in the query string
            String injection = "' OR '1'='1";
            statement.setString(1, injection);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("Username"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}