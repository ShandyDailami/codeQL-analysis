import java.sql.*;

public class java_31044_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try {
            // Step 1: Register the driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // Step 2: Open a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Perform a security-sensitive operation
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM your_table";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    // Process the result set
                    System.out.println(resultSet.getString("column_name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}