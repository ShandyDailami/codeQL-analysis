import java.sql.*;

public class java_32704_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a Connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute SQL Query
            String sql = "CREATE USER 'new_user'@'localhost' IDENTIFIED BY 'password'";
            stmt.executeUpdate(sql);

            sql = "GRANT SELECT ON testdb.* TO 'new_user'@'localhost'";
            stmt.executeUpdate(sql);

            // Step 4: Clean up
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}