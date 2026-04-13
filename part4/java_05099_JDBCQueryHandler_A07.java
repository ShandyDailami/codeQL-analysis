import java.sql.*;

public class java_05099_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Step 1: Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            statement = connection.createStatement();

            // Step 3: Execute a query
            String query = "SELECT * FROM my_table";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }

            // Step 5: Close the connection
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}