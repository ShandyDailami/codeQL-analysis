import java.sql.*;

public class java_39304_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 3: Set the parameter value
            statement.setString(1, "john"); // This is a security-sensitive operation

            // Step 4: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            // Step 5: Process the result
            while (resultSet.next()) {
                System.out.println(resultSet.getString("password"));
            }

            // Step 6: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}