import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_11682_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_11682_JDBCQueryHandler_A07(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            // Handle exception here
            System.out.println("Connection failed, please check the URL, Username and Password");
            e.printStackTrace();
        }
    }

    public boolean login(String username, String password) {
        String query = "SELECT * FROM Users WHERE username = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String dbPassword = result.getString("password");
                return password.equals(dbPassword); // Assume password is hashed and compared with dbPassword
            }
        } catch (SQLException e) {
            // Handle exception here
            System.out.println("Login failed, please check the username and password");
            e.printStackTrace();
        }

        return false; // Assume failed login
    }
}