import java.sql.*;

public class java_34214_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a statement
            statement = connection.createStatement();

            // Step 4: Execute a query
            String sql = "SELECT * FROM users WHERE id = " + 1; // This is a security-sensitive operation related to A08_IntegrityFailure
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 5: Handle the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}