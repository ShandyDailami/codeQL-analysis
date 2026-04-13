import java.sql.*;

public class java_20006_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:your_db_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            executeQuery(connection);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void executeQuery(Connection connection) throws SQLException {
        String query = "SELECT * FROM your_table";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String column1 = resultSet.getString("column1");
            int column2 = resultSet.getInt("column2");
            // Handle data as needed
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}