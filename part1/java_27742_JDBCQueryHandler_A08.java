import java.sql.*;

public class java_27742_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        System.out.println(login("admin", "password")); // Replace with actual values
    }

    public static boolean login(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, "username", "password");

            String query = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int count = result.getInt(1);
                if (count > 0) {
                    return true; // Login successful
                } else {
                    return false; // Login failed
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try { statement.close(); } catch (SQLException e) {}
            }
            if (connection != null) {
                try { connection.close(); } catch (SQLException e) {}
            }
        }
        return false; // Return false if connection or statement is not initialized
    }
}