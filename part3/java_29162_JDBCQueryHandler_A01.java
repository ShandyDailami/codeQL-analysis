import java.sql.*;
import java.util.Properties;

public class java_29162_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_29162_JDBCQueryHandler_A01(String dbURL, Properties props) throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, props);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/test";
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "password");

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(dbURL, props);
            ResultSet resultSet = handler.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                // handle the password in a secure way
                System.out.println("Username: " + username + ", Password: " + password);
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}