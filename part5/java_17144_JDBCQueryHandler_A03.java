import java.sql.*;

public class java_17144_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_17144_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnName"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("url", "username", "password");
        jdbcQueryHandler.executeQuery("SELECT * FROM tableName");
    }
}