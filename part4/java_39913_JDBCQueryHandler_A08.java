import java.sql.*;

public class java_39913_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Establish a Connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a Statement
            statement = connection.createStatement();

            // Step 3: Execute a Query
            String query = "SELECT * FROM tableName"; // Replace tableName with your actual table name
            resultSet = statement.executeQuery(query);

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the Resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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