import java.sql.*;

public class java_28491_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_28491_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Process the result set here
                System.out.println(resultSet.getString("column1"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Initialize the JDBCQueryHandler with your database credentials
        JDBCQueryHandler queryHandler = new JDBCQueryHandler("jdbc:your_database_url", "your_username", "your_password");

        // Run a query
        queryHandler.executeQuery("SELECT * FROM your_table");
    }
}