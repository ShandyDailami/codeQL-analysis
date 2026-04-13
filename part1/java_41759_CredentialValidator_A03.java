import java.sql.*;

public class java_41759_CredentialValidator_A03 {
    public boolean validate(String username, String password) {
        // Step 1: Connect to the database
        String url = "jdbc:mysql://localhost:3306/test";
        String driver = "com.mysql.jdbc.Driver";
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, "user", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Step 2: Prepare a SQL statement
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 3: Execute the SQL statement
        ResultSet result = null;
        try {
            result = statement.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}