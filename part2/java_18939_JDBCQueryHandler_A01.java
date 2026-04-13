import java.sql.*;

public class java_18939_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_18939_JDBCQueryHandler_A01(String url, String username, String password) {
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
                System.out.println(resultSet.getString("column_name"));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // This should be a secure configuration and should not be included in the final product
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("url", "username", "password");
        jdbcHandler.executeQuery("SELECT * FROM table");
    }
}