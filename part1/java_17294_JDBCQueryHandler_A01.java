import java.sql.*;

public class java_17294_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_17294_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Replace with your actual database credentials
        String url = "jdbc:mysql://localhost:3306/database_name";
        String username = "username";
        String password = "password";
        
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(url, username, password);
        jdbcQueryHandler.executeQuery("SELECT * FROM table_name");
    }
}