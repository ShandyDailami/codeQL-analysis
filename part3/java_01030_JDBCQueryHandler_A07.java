import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_01030_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_01030_JDBCQueryHandler_A07(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public List<String> getAuthFailureLogs() throws SQLException {
        List<String> logs = new ArrayList<>();

        String sql = "SELECT * FROM AUTH_FAILURE_LOGS";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            logs.add("Auth failure log: " + resultSet.getString("log"));
        }

        return logs;
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}