import java.sql.*;

public class java_21788_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            String sql = "SELECT * FROM mytable WHERE id = " + 123;
            ResultSet result = statement.executeQuery(sql);

            // Step 4: Handle the result
            while (result.next()) {
                System.out.println("Found a record with id = " + result.getString("id"));
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}