import java.sql.*;

public class java_37043_JDBCQueryHandler_A03 {
    private static String url = "jdbc:your_database_url";
    private static String username = "your_username";
    private static String password = "your_password";

    private Connection connection;

    public java_37043_JDBCQueryHandler_A03() {
        initializeConnection();
    }

    private void initializeConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void executeUpdate(String update) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler();
        ResultSet resultSet = jdbcHandler.executeQuery("SELECT * FROM your_table");
        while (resultSet.next()) {
            // Process the result set
        }
    }
}