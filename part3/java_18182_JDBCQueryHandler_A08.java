import java.sql.*;

public class java_18182_JDBCQueryHandler_A08 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            connection.setAutoCommit(false); // Disable auto commit

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the query
            String query = "INSERT INTO employees (id, name, salary) VALUES (1, null, 5000)";
            statement.executeUpdate(query);

            // Step 4: Handle the integrity failure (null values)
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                System.out.println("Inserted employee with id: " + resultSet.getInt(1));
            } else {
                System.out.println("No employee was inserted");
            }

            // Step 5: Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}