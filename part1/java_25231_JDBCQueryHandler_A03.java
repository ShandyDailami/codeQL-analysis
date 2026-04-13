import java.sql.*;

public class java_25231_JDBCQueryHandler_A03 {

    private Connection connection;

    public java_25231_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException appropriately
        }
    }

    public ResultSet executeQuery(String query, Object... parameters) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i + 1, parameters[i]);
            }
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException appropriately
            return null;
        }
    }

    public void executeUpdate(String query, Object... parameters) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i + 1, parameters[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException appropriately
        }
    }
}