import java.sql.*;

public class java_22557_JDBCQueryHandler_A07 {
    // Hardcoded connection details for the MySQL database
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Get a connection to the database
            Connection connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");

            // Step 4: Process the results
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // ...

                System.out.println("column1: " + column1);
                System.out.println("column2: " + column2);
                // ...
            }

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}