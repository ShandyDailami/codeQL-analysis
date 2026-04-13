import java.sql.*;

public class java_33185_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Execute a query
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM users WHERE username = 'admin' AND password = 'password'";
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Handle the results
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
           
                // This operation is a security-sensitive operation, so we should never print the password
                // System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}