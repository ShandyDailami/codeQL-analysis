import java.sql.*;

public class java_15897_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_15897_JDBCQueryHandler_A07(String url, String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        // Handle exception appropriately (e.g., log the error, throw an exception, etc.)
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately (e.g., log the error, throw an exception, etc.)
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately (e.g., log the error, throw an exception, etc.)
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately (e.g., log the error, throw an exception, etc.)
        }
    }
}