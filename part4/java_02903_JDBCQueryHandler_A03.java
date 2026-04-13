import java.sql.*;

public class java_02903_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_02903_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process the result set
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Add your SQL query here
        String query = "SELECT * FROM users";
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/db", "username", "password");
        handler.executeQuery(query);
    }
}