import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_01153_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_01153_JDBCQueryHandler_A01(String dbURL, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbURL, userName, password);
    }

    public List<String> executeQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<String> result = new ArrayList<>();
        while (rs.next()) {
            result.add(rs.getString(1));
        }
        return result;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}