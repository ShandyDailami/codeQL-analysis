import java.sql.*;

public class java_22651_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            // Example 1: Insert a new row into the table
            String insertQuery = "INSERT INTO test_table (id, name, email) VALUES (1, 'Test1', 'test1@example.com')";
            statement.executeUpdate(insertQuery);

            // Example 2: Update a row in the table
            String updateQuery = "UPDATE test_table SET name = 'Updated1' WHERE id = 1";
            statement.executeUpdate(updateQuery);

            // Example 3: Delete a row from the table
            String deleteQuery = "DELETE FROM test_table WHERE id = 1";
            statement.executeUpdate(deleteQuery);

            // Example 4: Select a row from the table
            String selectQuery = "SELECT * FROM test_table WHERE id = 1";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}