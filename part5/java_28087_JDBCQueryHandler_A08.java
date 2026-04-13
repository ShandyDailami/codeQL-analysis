import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_28087_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC driver

            String url = "jdbc:mysql://localhost:3306/mydb"; // JDBC url
            String username = "root"; // DB username
            String password = "password"; // DB password

            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO my_table (id, name) VALUES (1, 'Test')"; // SQL query

            Statement stmt = conn.createStatement(); // Create a statement
            stmt.executeUpdate(sql); // Execute the statement

            System.out.println("Inserted into my_table!");

            conn.close(); // Close the connection
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}