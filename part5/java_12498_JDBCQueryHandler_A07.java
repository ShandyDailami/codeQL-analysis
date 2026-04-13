import java.sql.*;

public class java_12498_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_12498_JDBCQueryHandler_A07(String url, String username, String password) {
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
                System.out.println("Result: " + resultSet.getString("result"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Initialize the handler with your database credentials
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_url", "username", "password");
        // Execute your query
        handler.executeQuery("SELECT * FROM your_table");
    }
}