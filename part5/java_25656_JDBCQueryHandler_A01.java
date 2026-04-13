import java.sql.*;

public class java_25656_JDBCQueryHandler_A01 {

    private String url;
    private String username;
    private String password;

    public java_25656_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            System.out.println("Error in SQL update: " + e.getMessage());
            return -1;
        }
    }
}