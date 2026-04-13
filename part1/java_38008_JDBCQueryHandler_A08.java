import java.sql.*;

public class java_38008_JDBCQueryHandler_A08 {
    // Define your credentials as private for security reasons
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/db_name";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Execute a query
            String query = "SELECT * FROM table_name WHERE condition"; // replace 'condition' with your actual condition
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Step 3: Process the results
            while (resultSet.next()) {
                // replace 'column_name' with your actual column name
                String columnValue = resultSet.getString("column_name");
                System.out.println(columnValue);
            }

            // Step 4: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}