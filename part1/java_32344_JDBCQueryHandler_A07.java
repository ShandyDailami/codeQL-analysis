import java.sql.*;

public class java_32344_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_32344_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(url, username, password);

            // Step 2: Obtain a statement object
            stmt = conn.createStatement();

            // Step 3: Execute the query and obtain a result set
            rs = stmt.executeQuery(query);

            // Step 4: Clean up
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
}