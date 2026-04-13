import java.sql.*;
import java.util.Properties;

public class java_41911_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_41911_JDBCQueryHandler_A08() {
        String url = "jdbc:your_driver_name://your_host_name/your_database_name";
        Properties props = new Properties();
        props.setProperty("user", "your_username");
        props.setProperty("password", "your_password");
        try {
            this.connection = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int executeUpdate(String query) {
        Statement statement = null;
        int rowsAffected = 0;
        try {
            statement = this.connection.createStatement();
            rowsAffected = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}