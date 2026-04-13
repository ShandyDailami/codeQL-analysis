import java.sql.*;

public class java_09257_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a statement
            String sql = "DELETE FROM tablename";
            Statement stmt = conn.createStatement();

            // Step 4: Execute the statement
            int rowsDeleted = stmt.executeUpdate(sql);

            System.out.println("Deleted rows: " + rowsDeleted);

            // Step 5: Close the connection
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}