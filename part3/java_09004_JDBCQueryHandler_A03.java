import java.sql.*;

public class java_09004_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1. Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. Execute a query
            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // 4. Process the result
            while (rs.next()) {
                System.out.println("User found!");
            }

            // 5. Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}