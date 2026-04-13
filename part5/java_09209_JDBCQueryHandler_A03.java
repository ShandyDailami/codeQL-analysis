import java.sql.*;

public class java_09209_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_09209_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void executeUpdate(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Inject connection details (URL, username, password) into JDBCQueryHandler
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

        // Execute a simple query
        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM Users");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }

        // Execute an update query (delete a user)
        jdbcQueryHandler.executeUpdate("DELETE FROM Users WHERE username='test'");
    }
}