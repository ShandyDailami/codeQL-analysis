import java.sql.*;
import java.util.Properties;

public class java_22128_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_22128_JDBCQueryHandler_A07() {
        Properties properties = new Properties();
        properties.setProperty("user","username");
        properties.setProperty("password","password");
        properties.setProperty("useSSL","false");
        properties.setProperty("autoReconnect","true");
        properties.setProperty("characterEncoding","UTF-8");

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void executeUpdate(String query) {
        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        ResultSet resultSet = handler.executeQuery("SELECT * FROM Users");

        try {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}