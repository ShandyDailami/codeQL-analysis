import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_26948_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            // select statement for checking the integrity of the A08_IntegrityFailure table
            String sql = "SELECT COUNT(*) FROM A08_IntegrityFailure";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int count = rs.getInt(1);
            System.out.println("Count of rows in A08_IntegrityFailure table: " + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}