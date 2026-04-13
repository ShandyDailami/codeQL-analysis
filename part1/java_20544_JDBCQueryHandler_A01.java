import java.sql.*;

public class java_20544_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_20544_JDBCQueryHandler_A01(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String update) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");
        ResultSet resultSet = jdbcHandler.executeQuery("SELECT * FROM mytable");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("column1"));
        }
        jdbcHandler.closeConnection();
    }
}