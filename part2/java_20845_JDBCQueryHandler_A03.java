import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_20845_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // establish connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password")) {

            // create a statement
            try (Statement stmt = conn.createStatement()) {

                // execute a query
                ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

                // process the result set
                while (rs.next()) {
                    System.out.println(rs.getString("Name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}