import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13594_JDBCQueryHandler_A01 {

    public static void main(String[] args) {

        // Step 1: Load MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Establish a connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        Connection connection = null;
        Statement stmt = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            stmt = connection.createStatement();

            // Step 3: Execute a SELECT query
            String sql = "SELECT * FROM mytable";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(name + " - " + age);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Clean up
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}