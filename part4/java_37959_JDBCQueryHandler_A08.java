import java.sql.*;

public class java_37959_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Perform SQL query
            String query = "SELECT * FROM user JOIN password ON user.id = password.id WHERE user.username = ? AND password.password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "testUser");
            statement.setString(2, "testPassword");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("Found user: " + result.getString("username"));
            }

            // Step 4: Close connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}