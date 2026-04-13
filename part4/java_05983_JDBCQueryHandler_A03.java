import java.sql.*;

public class java_05983_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_05983_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        return statement.executeQuery();
    }

    public void executeUpdate(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
        statement.executeUpdate();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
            ResultSet resultSet = handler.executeQuery("SELECT * FROM Users WHERE username = ? AND password = ?", "user1", "password1");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }
            handler.executeUpdate("UPDATE Users SET password = ? WHERE username = ?", "newPassword", "user1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}