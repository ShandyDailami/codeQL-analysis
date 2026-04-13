import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_23846_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_23846_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public List<String> executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<String> results = new ArrayList<>();
        while (resultSet.next()) {
            results.add(resultSet.getString("column_name"));
        }
        return results;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/db", "username", "password");
            List<String> results = handler.executeQuery("SELECT * FROM table");
            for (String result : results) {
                System.out.println(result);
            }
            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}