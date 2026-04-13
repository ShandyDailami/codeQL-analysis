import java.sql.*;

public class java_16884_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare the statement
            String insertUserQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertUserQuery);
            insertStatement.setString(1, "user1");
            insertStatement.setString(2, "password1");
            insertStatement.executeUpdate();

            String selectUserQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectUserQuery);
            selectStatement.setString(1, "user1");
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Step 3: Delete the user
            String deleteUserQuery = "DELETE FROM users WHERE username = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteUserQuery);
            deleteStatement.setString(1, "user1");
            deleteStatement.executeUpdate();

            // Step 4: Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}