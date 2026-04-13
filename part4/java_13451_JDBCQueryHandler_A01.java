import java.sql.*;
import java.util.Properties;

public class java_13451_JDBCQueryHandler_A01 {
    private Connection connection;
    private Statement statement;

    public java_13451_JDBCQueryHandler_A01(String dbUrl, String userName, String password) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", userName);
        props.setProperty("password", password);

        connection = DriverManager.getConnection(dbUrl, props);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");

            ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("User Name: " + resultSet.getString("name"));
            }

            jdbcQueryHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}