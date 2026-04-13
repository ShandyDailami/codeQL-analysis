import java.sql.*;

public class java_22623_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn;

    public java_22623_JDBCQueryHandler_A03() {
        try {
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query, ResultHandler handler) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                handler.handle(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public interface ResultHandler {
        void handle(ResultSet rs);
    }
}