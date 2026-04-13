import java.sql.*;

public class java_00887_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_00887_JDBCQueryHandler_A03(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query, String parameter) {
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, parameter);
            result = statement.executeQuery();

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}