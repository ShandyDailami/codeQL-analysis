import java.sql.*;

public class java_33854_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_33854_JDBCQueryHandler_A07(String url, String username, String password) {
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
            System.out.println("An error occurred while executing the query: " + e.getMessage());
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
            System.out.println("An error occurred while executing the query: " + e.getMessage());
            return -1;
        }
    }
}