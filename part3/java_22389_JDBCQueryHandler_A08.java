import java.sql.*;

public class java_22389_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Creating connection
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Opening statement
            try (Statement statement = connection.createStatement()) {
                // Executing SQL query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM table_name");
                while (resultSet.next()) {
                    // Printing result
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}