import java.sql.*;

public class java_27269_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn;

    private java_27269_JDBCQueryHandler_A01() {
        try {
            this.conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class SingletonHolder {
        private static final JDBCQueryHandler INSTANCE = new JDBCQueryHandler();
    }

    public static JDBCQueryHandler getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void performQuery(String query) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}