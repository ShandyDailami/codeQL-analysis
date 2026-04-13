import java.sql.*;

public class java_41116_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE id = " + 123);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                // Here, we assume that the integrity check for the name is done in the following line
                // if the name is null or not present, the integrity failure is detected
                if (name == null || name.isEmpty()) {
                    System.out.println("Integrity Failure: name cannot be null or empty");
                }
            }

            // Step 4: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}