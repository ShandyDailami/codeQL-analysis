import java.sql.*;

public class java_08479_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_08479_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        connection.close();
        return resultSet;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:your_database_url";
            String username = "your_username";
            String password = "your_password";

            JDBCQueryHandler queryHandler = new JDBCQueryHandler(url, username, password);
            ResultSet resultSet = queryHandler.executeQuery("SELECT * FROM your_table");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("your_column_name"));
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}