import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34917_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM employees WHERE id = " + args[0];
        try (Connection conn = connection;
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }
}