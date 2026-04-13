import java.sql.*;

public class java_33214_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myusername";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        executeQuery("SELECT * FROM mytable");
    }

    public static void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Found row: " + resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}