import java.sql.*;

public class java_21849_JDBCQueryHandler_A03 {

    private Connection connection;
    private String url;
    private String username;
    private String password;

    public java_21849_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
    }

    public void close() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
            handler.connect();

            ResultSet resultSet = handler.executeQuery("SELECT * FROM users WHERE name=?");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}