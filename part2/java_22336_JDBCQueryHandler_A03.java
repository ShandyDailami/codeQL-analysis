import java.sql.*;

public class java_22336_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // URL, username, and password for MySQL
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Step 4: Set the parameter and execute the statement
            preparedStatement.setString(1, "admin"); // assuming 'admin' is the username in the 'users' table
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Process the result
            while (resultSet.next()) {
                String usernameFromDB = resultSet.getString("username");
                System.out.println("Username from the database: " + usernameFromDB);
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}