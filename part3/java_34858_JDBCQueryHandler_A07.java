import java.sql.*;

public class java_34858_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_34858_JDBCQueryHandler_A07(String url, String username, String password) {
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
                // Here you can process the data, e.g., log it, use it, etc.
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("url", "username", "password");
        jdbcQueryHandler.executeQuery("SELECT * FROM table");
    }
}