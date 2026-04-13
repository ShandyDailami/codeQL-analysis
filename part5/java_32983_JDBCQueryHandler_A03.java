import java.sql.*;

public class java_32983_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            String sql = "SELECT * FROM my_table"; // replace with your query
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Process the results
            while (resultSet.next()) {
                // replace 'column_name' with the actual column name you are interested in
                String columnValue = resultSet.getString("column_name");
                System.out.println("Column Value: " + columnValue);
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}