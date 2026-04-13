import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05872_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Step 2: Establish the database connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password"
            );

            // Step 3: Prepare the SQL statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM myTable");

            // Step 4: Process the result set
            while (rs.next()) {
                // Process the result set row
                System.out.println(rs.getString("myColumn"));
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}