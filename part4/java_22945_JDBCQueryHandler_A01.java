import java.sql.*;

public class java_22945_JDBCQueryHandler_A01 {

    // private fields to hold database connection info
    private String url;
    private String username;
    private String password;

    // Constructor
    public java_22945_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Method to execute a query
    public ResultSet executeQuery(String query) {
        // Try-with-resources statement is used here to ensure the database connection is properly closed after usage
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            System.out.println("Error while executing query: " + ex.getMessage());
        }
        return null;
    }

    // Method to execute a prepared statement
    public int executeUpdate(String query, ArrayList<Object> parameters) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error while executing update: " + ex.getMessage());
        }
        return -1;
    }
}