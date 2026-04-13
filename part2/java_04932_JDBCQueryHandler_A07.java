import java.sql.*;

public class java_04932_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_04932_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return resultSet;
    }

    public static void main(String[] args) throws SQLException {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        ResultSet resultSet = queryHandler.executeQuery("SELECT * FROM Users WHERE username = 'test' AND password = 'test'");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("password"));
        }
    }
}