import java.sql.*;

public class java_06305_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            executeQuery(connection);
            executeUpdate(connection);
            closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void executeQuery(Connection connection) throws SQLException {
        String query = "SELECT * FROM table_name";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String column1 = resultSet.getString("column1");
            int column2 = resultSet.getInt("column2");
            // perform some operation with the result
        }
    }

    private static void executeUpdate(Connection connection) throws SQLException {
        String query = "UPDATE table_name SET column1='value' WHERE condition";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    private static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}