import java.sql.*;

public class java_20856_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_20856_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Set the credentials for the database connection.
        // In a real-world application, these would likely come from a secure configuration file or environment variable.
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        handler.executeQuery("SELECT * FROM Users WHERE Name='John'");
    }
}