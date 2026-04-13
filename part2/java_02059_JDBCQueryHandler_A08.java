import java.sql.*;

public class java_02059_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:your_db_url";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Register the driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // Step 2: Open a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");

            // Step 4: Process the result set
            while (resultSet.next()) {
                // You can access the data here
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");

                // You can also execute update, insert or delete operations
                // statement.executeUpdate("UPDATE your_table SET column1='value' WHERE condition");
            }

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}