import java.sql.*;

public class java_14822_JDBCQueryHandler_A01 {
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";

    public static void main(String[] args) {
        // Step 1: Establish a connection to the database
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database");

            // Step 2: Perform a security-sensitive operation
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM sensitive_table");

                // Step 3: Process the result set
                while (resultSet.next()) {
                    String column1 = resultSet.getString("column1");
                    String column2 = resultSet.getString("column2");

                    System.out.println("Column1: " + column1);
                    System.out.println("Column2: " + column2);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}