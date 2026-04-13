import java.sql.*;

public class java_37971_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");

            // Step 2: Create a statement
            Statement statement = connection.createStatement();
            System.out.println("Statement created");

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");
            System.out.println("Query executed");

            // Step 4: Process the result set
            while (resultSet.next()) {
                System.out.println("Row: " + resultSet.getString("columnName"));
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            System.out.println("Error in connecting to database or executing query: " + e.getMessage());
        }
    }
}