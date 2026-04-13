import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_35938_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            // create a statement
            Statement stmt = conn.createStatement();

            // execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable WHERE mycondition");

            while (rs.next()) {
                // print the result
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in querying: " + e.getMessage());
        }
    }
}