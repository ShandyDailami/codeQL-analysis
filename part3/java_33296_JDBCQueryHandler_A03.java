import java.sql.*;

public class java_33296_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        // Assuming database credentials are provided
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");

            // Step 4: Process the results
            while (resultSet.next()) {
                System.out.println("Row: " + resultSet.getString("column1") + ", " +
                        resultSet.getString("column2"));
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to the database or executing the query: " + e.getMessage());
        }
    }
}