import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_37482_JDBCQueryHandler_A03 {

    // private fields
    private String url;
    private String username;
    private String password;

    // Constructor
    public java_37482_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Method to open the connection
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Method to close the connection
    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    // Method to perform a query
    public void performQuery(Connection conn, String query) {
        try {
            if (conn != null && conn.isClosed()) {
                throw new SQLException("Connection is closed.");
            }
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // do something with rs
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Error in query: " + ex.getMessage());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
            Connection conn = handler.openConnection();

            String query = "SELECT * FROM my_table";
            handler.performQuery(conn, query);

            handler.closeConnection();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}