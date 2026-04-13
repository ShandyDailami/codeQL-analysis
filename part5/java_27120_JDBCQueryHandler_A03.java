import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_27120_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM my_table"; // replace this with your query
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("Row 1: " + rs.getString("column1"));
                System.out.println("Row 2: " + rs.getString("column2"));
                // and so on...
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in database connection: " + e.getMessage());
        }
    }
}