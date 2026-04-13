import java.sql.*;

public class java_19769_JDBCQueryHandler_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            executeQuery();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    private static void executeQuery() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:your_database_url", USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");

        while (resultSet.next()) {
            // Process the result set
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}