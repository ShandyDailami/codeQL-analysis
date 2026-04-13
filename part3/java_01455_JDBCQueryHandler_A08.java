import java.sql.*;

public class java_01455_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            statement = connection.createStatement();

            // Step 3: Execute a SELECT query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 4: Execute an INSERT query
            statement.executeUpdate("INSERT INTO Users (name, age) VALUES ('John', 25)");

            // Step 5: Execute an UPDATE query
            statement.executeUpdate("UPDATE Users SET age = 30 WHERE name = 'John'");

            // Step 6: Execute a DELETE query
            statement.executeUpdate("DELETE FROM Users WHERE name = 'John'");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close the statement and connection
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