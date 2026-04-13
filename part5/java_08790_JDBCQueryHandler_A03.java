import java.sql.*;

public class java_08790_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_08790_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void performQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                // Process the result set
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while performing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        // Construct the JDBCQueryHandler
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(url, username, password);

        // Perform a query
        String query = "SELECT * FROM users";
        jdbcQueryHandler.performQuery(query);
    }
}