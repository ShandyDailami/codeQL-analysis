import java.sql.*;

public class java_04043_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myusername";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                // Your query here
                executeQuery(connection);
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    private static void executeQuery(Connection connection) throws SQLException {
        String query = "SELECT * FROM my_table";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("column_name"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}