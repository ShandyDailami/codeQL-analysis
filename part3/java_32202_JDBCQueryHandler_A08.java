import java.sql.*;

public class java_32202_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_32202_JDBCQueryHandler_A08(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database_url", "username", "password");
        ResultSet resultSet = handler.executeQuery("SELECT * FROM your_table");
        while (resultSet.next()) {
            // process your data here
        }
    }
}