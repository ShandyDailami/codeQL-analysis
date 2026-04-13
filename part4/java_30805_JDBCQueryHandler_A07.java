import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_30805_JDBCQueryHandler_A07 {

    private Connection connection;

    public java_30805_JDBCQueryHandler_A07() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb?useSSL=false", "username", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void authenticateUser(String username, String password) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        if (!resultSet.isBeforeFirst()) {
            throw new SQLException("Authentication failed");
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        try {
            handler.authenticateUser("user1", "password1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}