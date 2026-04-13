import java.sql.*;

public class java_41052_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            String query = "SELECT * FROM User WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 3: Set parameters and execute the query
            preparedStatement.setString(1, "user1");
            preparedStatement.setString(2, "password1");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Access granted!");
            } else {
                System.out.println("Access denied!");
            }

            // Step 4: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}