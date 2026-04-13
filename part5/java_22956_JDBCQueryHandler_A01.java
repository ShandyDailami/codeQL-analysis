import java.sql.*;

public class java_22956_JDBCQueryHandler_A01 {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a SQL query
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "admin"); // Adjust this to the username you want to check

            // Step 3: Execute the query and handle the result
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            // Step 4: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}