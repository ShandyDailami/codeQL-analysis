import java.sql.*;

public class java_30439_JDBCQueryHandler_A01 {
    private Connection conn;
    private Statement stmt;

    public java_30439_JDBCQueryHandler_A01(String dbURL, String user, String password) {
        try {
            // Step 1: Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            this.conn = DriverManager.getConnection(dbURL, user, password);

            // Step 3: Create a statement
            this.stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Step 1: Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Step 2: Print the result
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String query) {
        try {
            // Step 1: Execute the query
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a new JDBCQueryHandler
        JDBCQueryHandler jdbc = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");

        // Execute a query
        jdbc.executeQuery("SELECT * FROM Users");

        // Execute an update query
        jdbc.executeUpdate("UPDATE Users SET password='newpassword' WHERE username='user'");
    }
}