import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_13820_JDBCQueryHandler_A08 {
    private final String url;
    private final String user;
    private final String password;

    public java_13820_JDBCQueryHandler_A08(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void execute(String sql) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error executing SQL: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // Ignore for now
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Ignore for now
                }
            }
        }
    }
}