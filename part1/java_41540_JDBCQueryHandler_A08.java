import java.sql.*;

public class java_41540_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_41540_JDBCQueryHandler_A08(String url, String username, String password) {
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
            System.out.println("Error in processing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Change the URL, username, and password to match your MySQL instance
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        handler.executeQuery("SELECT name FROM my_table");
    }
}