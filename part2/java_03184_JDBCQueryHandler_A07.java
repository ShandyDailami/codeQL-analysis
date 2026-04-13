import java.sql.*;
import java.util.Properties;

public class java_03184_JDBCQueryHandler_A07 {

    private Connection connection = null;
    private Statement stmt = null;

    public java_03184_JDBCQueryHandler_A07(String dbURL, String user, String password) throws SQLException {
        try {
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);

            connection = DriverManager.getConnection(dbURL, props);
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // Replace with your own database URL, user and password
            JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("jdbc:your_db_url", "user", "password");

            // Example of a secure operation
            String query = "SELECT * FROM users WHERE role = 'admin'";
            ResultSet resultSet = jdbcHandler.executeQuery(query);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            jdbcHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}