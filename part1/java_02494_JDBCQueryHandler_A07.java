import java.sql.*;
import java.util.Properties;

public class java_02494_JDBCQueryHandler_A07 {
    private static Connection connection;

    public static void main(String[] args) {
        connectToDB();
        performQuery("SELECT * FROM Users");
        disconnect();
    }

    private static void connectToDB() {
        try {
            Properties props = new Properties();
            props.setProperty("user", "your_username");
            props.setProperty("password", "your_password");
            props.setProperty("useSSL", "false");
            props.setProperty("serverSelection", "your_server_selection");
            connection = DriverManager.getConnection("your_database_url", props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void performQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}