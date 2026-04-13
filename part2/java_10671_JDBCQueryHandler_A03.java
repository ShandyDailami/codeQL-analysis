import java.sql.*;

public class java_10671_JDBCQueryHandler_A03 {

    private Connection conn;

    public java_10671_JDBCQueryHandler_A03(String url, String user, String password) {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("url", "user", "password");
        ResultSet result = handler.executeQuery("SELECT * FROM table");
        while (result.next()) {
            System.out.println(result.getString("column"));
        }
    }
}