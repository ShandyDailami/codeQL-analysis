import java.sql.*;

public class java_36440_JDBCQueryHandler_A08 {

    // Assuming JDBC driver is in classpath
    private static final String URL = "your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void executeQuery(String query, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("column_name"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler();
            Connection connection = handler.getConnection();
            handler.executeQuery("your_query", connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}