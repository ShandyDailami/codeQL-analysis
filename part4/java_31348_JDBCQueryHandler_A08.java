import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_31348_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM table_name")) {

            while (rs.next()) {
                // Here you can handle the result set, for example, print it
                System.out.println(rs.getString("column_name"));
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while connecting to database or executing query: " + e.getMessage());
        }
    }
}