import java.sql.*;

public class java_33433_JDBCQueryHandler_A03 {
    private Connection connection;
    private Statement statement;

    public java_33433_JDBCQueryHandler_A03(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}