import java.sql.*;

public class java_35421_JDBCQueryHandler_A01 {

    private String url;
    private String username;
    private String password;

    public java_35421_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void closeConnection(ResultSet rs, Statement stmt, Connection conn) throws SQLException {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler queryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
            ResultSet rs = queryHandler.executeQuery("SELECT * FROM Users");
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
            queryHandler.closeConnection(rs, null, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}