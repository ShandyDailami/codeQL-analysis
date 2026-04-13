import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_24404_JDBCQueryHandler_A03 {

    private Connection connection;

    public java_24404_JDBCQueryHandler_A03(String dbURL, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, user, password);
    }

    public List<String> runSelectQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<String> result = new ArrayList<>();
        while (rs.next()) {
            result.add(rs.getString("your_column_name"));
        }
        return result;
    }

    public void runUpdateQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}