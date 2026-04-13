import java.sql.*;

public class java_35045_JDBCQueryHandler_A08 {

    // Security-sensitive operation: Connection
    private final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private final String USER = "root";
    private final String PASS = "password";

    private Connection conn;

    public java_35045_JDBCQueryHandler_A08() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    // Security-sensitive operation: PreparedStatement
    public void executeUpdate(String query) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update failed!");
            e.printStackTrace();
        }
    }

    // Security-sensitive operation: ResultSet
    public ResultSet executeQuery(String query) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Query failed!");
            e.printStackTrace();
            return null;
        }
    }

    // Security-sensitive operation: Closing the connection
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection closing failed!");
            e.printStackTrace();
        }
    }
}