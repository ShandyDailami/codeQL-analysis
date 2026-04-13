import java.sql.*;

public class java_17919_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Perform a SQL query
            String sql = "SELECT * FROM Users WHERE UserID = ? AND Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "user1");
            preparedStatement.setString(2, "password1");

            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Handle the results
            while (resultSet.next()) {
                String userId = resultSet.getString("UserID");
                String password = resultSet.getString("Password");
                System.out.println("User ID: " + userId);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}