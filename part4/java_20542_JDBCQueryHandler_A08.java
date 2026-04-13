import java.sql.*;

public class java_20542_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            Statement stmt = conn.createStatement();

            // Step 4: Execute SQL statement
            String sql = "INSERT INTO users (username, password) VALUES ('user1', 'pass1')";
            stmt.executeUpdate(sql);

            // Step 5: Retrieve data from the database
            String selectSQL = "SELECT username, password FROM users";
            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                System.out.println("username = " + rs.getString("username"));
                System.out.println("password = " + rs.getString("password"));
            }

            // Step 6: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}