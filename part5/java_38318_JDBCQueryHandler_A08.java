import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_38318_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "root";
    private static Connection conn = null;

    static {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getIntegrityFailure() {
        List<String> result = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM A08_IntegrityFailure");

            while (rs.next()) {
                String row = rs.getString("row");
                result.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        List<String> rows = handler.getIntegrityFailure();

        for (String row : rows) {
            System.out.println(row);
        }
    }
}