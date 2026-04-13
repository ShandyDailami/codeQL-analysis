import java.sql.*;

public class java_25306_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Execute a query
            String sql = "SELECT * FROM employees WHERE id = '" + args[0] + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Process the result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("Name: " + name);
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}