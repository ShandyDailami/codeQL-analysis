import java.sql.*;

public class java_14749_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private void connectToDB() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void disconnectDB() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getData() {
        connectToDB();
        String query = "SELECT * FROM your_table";
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnectDB();
        }
    }

    public static void main(String[] args) {
        VanillaJavaJDBCQueryHandler handler = new VanillaJavaJDBCQueryHandler();
        handler.getData();
    }
}