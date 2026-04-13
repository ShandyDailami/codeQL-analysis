import java.sql.*;

public class java_12056_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_12056_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "password";
            String query = "SELECT * FROM Users";

            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
            ResultSet resultSet = handler.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            handler.close(null, null, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}