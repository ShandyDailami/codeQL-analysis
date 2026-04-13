import java.sql.*;

public class java_02167_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_02167_JDBCQueryHandler_A08(String url, String user, String password) {
        try {
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String update) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("url", "user", "password");
        ResultSet rs = handler.executeQuery("SELECT * FROM table");
        while (rs.next()) {
            System.out.println(rs.getString("column1") + " " + rs.getString("column2"));
        }
        handler.executeUpdate("UPDATE table SET column1 = 'newValue' WHERE condition");
    }
}