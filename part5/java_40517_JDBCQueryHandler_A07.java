import java.sql.*;

public class java_40517_JDBCQueryHandler_A07 {
    // Define your connection string here.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Establish a connection
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute a query
            String sql = "SELECT * FROM my_table"; // Replace with your actual query
            resultSet = statement.executeQuery(sql);

            // 4. Process the result set
            while (resultSet.next()) {
                // Replace 'column_name' with the actual column name
                String columnName = resultSet.getString("column_name");
                System.out.println(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Clean up
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}