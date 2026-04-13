import java.sql.*;

public class java_07692_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "user1"); // replace with the actual username
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String dbUsername = result.getString("username");
                // if usernames match, continue to authenticate.
                if (dbUsername.equals("user1")) {
                    System.out.println("Authentication successful!");
                } else {
                    System.out.println("Authentication failed!");
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}