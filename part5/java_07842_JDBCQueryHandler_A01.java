import java.sql.*;

public class java_07842_JDBCQueryHandler_A01 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Create a connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Example of a secure query handler
    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    // Example of a secure query handler with parameters
    public ResultSet executeQueryWithParams(String query, Object... params) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }

        return statement.executeQuery();
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // Example of a secure query
        try (ResultSet resultSet = handler.executeQuery("SELECT * FROM Users WHERE Id = ?")) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Example of a secure query with parameters
        try (ResultSet resultSet = handler.executeQueryWithParams(
                "SELECT * FROM Orders WHERE CustomerId = ? AND ProductId = ?", 123, 456
        )) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("OrderDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}