import java.sql.*;

public class java_00858_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Get a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Execute a SQL query
            String sql = "SELECT * FROM my_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 3: Check the integrity of the row
            while (resultSet.next()) {
                boolean isDeleted = resultSet.getBoolean("is_deleted");

                if (isDeleted) {
                    System.out.println("The row has been deleted.");
                } else {
                    System.out.println("The row has not been deleted.");
                }
            }

            // Step 4: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}