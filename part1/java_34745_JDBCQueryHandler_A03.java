import java.sql.*;

public class java_34745_JDBCQueryHandler_A03 {
    // Define database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Establish a connection to the database
    private Connection conn = null;

    // Prepared statements
    private PreparedStatement pstmt = null;

    // Constructor
    public java_34745_JDBCQueryHandler_A03() {
        try {
            // Load the driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a query
    public void executeQuery(String query) {
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();
        queryHandler.executeQuery("SELECT * FROM Users");
    }
}