import java.sql.*;

public class java_34073_JDBCQueryHandler_A03 {
    private Connection connection;

    public java_34073_JDBCQueryHandler_A03(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    public void executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("email"));
        }
        resultSet.close();
        statement.close();
    }

    public static void main(String[] args) {
        try {
            new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password").executeQuery("SELECT username, email FROM users WHERE username = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}