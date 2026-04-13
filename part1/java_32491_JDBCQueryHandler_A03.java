import java.sql.*;

public class java_32491_JDBCQueryHandler_A03 {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private final String USER = "root";
    private final String PASS = "root";

    public void connect() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}