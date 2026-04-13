import java.sql.*;

public class java_38840_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");

            // Step 4: Process the result set
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // Process the columns...
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