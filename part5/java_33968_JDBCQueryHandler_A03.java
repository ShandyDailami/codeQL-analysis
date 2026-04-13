import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_33968_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:legacy_database_url";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM legacy_table");

            while (rs.next()) {
                System.out.println("Legacy record: " + rs.getString("column1") + ", " + rs.getString("column2"));
            }

        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}