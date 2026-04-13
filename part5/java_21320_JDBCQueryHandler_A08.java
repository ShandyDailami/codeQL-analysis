import java.sql.*;

public class java_21320_JDBCQueryHandler_A08 {

    private String url;
    private String username;
    private String password;

    public java_21320_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("column1"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Initialize the JDBCQueryHandler with your database credentials
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("url", "username", "password");

        // Execute a query
        jdbcQueryHandler.executeQuery("SELECT * FROM table");
    }
}