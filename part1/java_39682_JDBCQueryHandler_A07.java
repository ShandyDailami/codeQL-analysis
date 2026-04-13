import java.sql.*;

public class java_39682_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String DB_USERNAME = "your_username";
    private static final String DB_PASSWORD = "your_password";

    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";

    public String getPassword(String username) {
        String password = null;

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Step 2: Prepare a statement
            String sql = "SELECT password FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            // Step 3: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                password = resultSet.getString("password");
            }

            // Step 4: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return password;
    }
}