import java.sql.*;

public class java_11893_SessionManager_A08 {
    private Connection connection;
    private Statement statement;

    public java_11893_SessionManager_A08(String url, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
       
            // In real world, you would handle this differently
            System.exit(1);
        }
    }

    public void executeStatement(String sql) {
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            // In real world, you would handle this differently
            System.exit(1);
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            // In real world, you would handle this differently
            System.exit(1);
            return null;
        }
    }

    public void closeConnection() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // In real world, you would handle this differently
            System.exit(1);
        }
    }
}