import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_17149_JDBCQueryHandler_A08 {

    private static final String URL = "your_db_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public void insertIntoTable(String tableName, String data) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            String sql = "INSERT INTO " + tableName + " (data) VALUES (?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, data);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.insertIntoTable("your_table", "your_data");
    }
}