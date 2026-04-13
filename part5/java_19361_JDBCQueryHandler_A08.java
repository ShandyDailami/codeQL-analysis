import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_19361_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_19361_JDBCQueryHandler_A08(String dbURL, String userName, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");

        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM users WHERE role = 'admin'");

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            System.out.println("Name: " + name + ", Email: " + email);
        }

        jdbcQueryHandler.close();
    }
}