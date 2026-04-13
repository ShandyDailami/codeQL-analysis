import java.sql.*;

public class java_40708_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                executeQuery(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void executeQuery(Connection connection) throws SQLException {
        String sql = "SELECT * FROM users WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "John"); // You should never store user-provided input directly in a SQL statement.
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            String name = result.getString("name");
            // Do something with the name
        }

        result.close();
        statement.close();
    }
}