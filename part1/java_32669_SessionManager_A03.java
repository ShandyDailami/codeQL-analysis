import java.sql.*;

public class java_32669_SessionManager_A03 {
    // URL and credentials
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Driver and Connection
    private Connection conn;

    public java_32669_SessionManager_A03() {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createSession(String query) {
        try {
            // Prepare statement
            Statement stmt = conn.createStatement();

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

            // Process result
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
            }

            // Close connection
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.createSession("SELECT * FROM Users");
    }
}