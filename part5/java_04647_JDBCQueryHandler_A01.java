import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_04647_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Step 3: Execute a query
            String sql = "SELECT * FROM my_table";
            java.sql.Statement stmt = connection.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the results
            while (rs.next()) {
                System.out.println("id = " + rs.getString("id"));
                System.out.println("name = " + rs.getString("name"));
            }

            // Step 5: Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}