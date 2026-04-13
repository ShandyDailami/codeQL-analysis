import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_40369_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_40369_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void executeQuery(String query, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("column_name"));
        }

        resultSet.close();
        statement.close();
    }

    public void executeUpdate(String query, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();

        statement.close();
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");
        Connection connection = null;

        try {
            connection = handler.getConnection();
            handler.executeQuery("SELECT * FROM my_table", connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            handler.closeConnection(connection);
        }
    }
}