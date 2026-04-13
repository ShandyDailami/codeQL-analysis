import java.sql.*;

public class java_16478_JDBCQueryHandler_A03 {

    private Connection connection;

    public java_16478_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // You would typically use a configuration file or a set of properties to pass the database url, username and password
        // Here, I'm just using some test values
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
        handler.executeQuery("SELECT * FROM Users WHERE email = ?");
    }
}