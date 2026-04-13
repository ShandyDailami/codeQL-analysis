import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_28197_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM my_table";
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println("Found row: " + rs.getString("column_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}