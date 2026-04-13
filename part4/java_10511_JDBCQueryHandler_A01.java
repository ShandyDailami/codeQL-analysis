import java.sql.*;

public class java_10511_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            Statement statement = connection.createStatement();

            // Step 3: Execute a security-sensitive query
            String sql = "SELECT * FROM users WHERE password = 'password'";
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 4: Process the result set
            while (resultSet.next()) {
                // This is a security-sensitive operation, access is denied if password is incorrect
                String passwordInDB = resultSet.getString("password");
                if ("incorrectpassword".equals(passwordInDB)) {
                    System.out.println("Access Denied!");
                } else {
                    System.out.println("Access Granted!");
                }
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