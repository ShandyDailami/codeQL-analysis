import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_33044_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_33044_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public List<String> query(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<String> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(resultSet.getString("columnName"));
        }

        return result;
    }

    public void update(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("url", "username", "password");
            List<String> result = handler.query("SELECT * FROM table");
            for (String s : result) {
                System.out.println(s);
            }
            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}