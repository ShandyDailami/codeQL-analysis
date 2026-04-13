import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_41093_JDBCQueryHandler_A03 {

    private Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private final String username = "root";
    private final String password = "password";

    public java_41093_JDBCQueryHandler_A03() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            if (conn != null && !conn.isClosed()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String query) {
        try {
            if (conn != null && !conn.isClosed()) {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(query);
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users");
        handler.executeUpdate("INSERT INTO users (name, age) VALUES ('John', 25)");
    }
}