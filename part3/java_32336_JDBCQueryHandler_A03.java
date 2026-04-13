import java.sql.*;

public class java_32336_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_32336_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public static void main(String[] args) {
        // Use your own database connection details
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

        // Example query
        String query = "SELECT * FROM users WHERE email = ?";

        try (ResultSet resultSet = handler.executeQuery(query)) {
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                // Do something with the email
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}