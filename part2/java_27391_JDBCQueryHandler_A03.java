import java.sql.*;

public class java_27391_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_27391_JDBCQueryHandler_A03(String dbUrl, String username, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(String username, String password) {
        String query = "INSERT INTO USERS (username, password) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}