import java.sql.*;
import java.util.Properties;

public class java_09863_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("user", "dbuser");
        props.setProperty("password", "dbpass");
        props.setProperty("useSSL", "false");
        props.setProperty("serverTimezone", "UTC");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", props);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM mytable WHERE id = '" + args[0] + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // TODO: Handle resultSet data
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}