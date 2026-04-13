import java.sql.*;

public class java_10381_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_10381_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query, Object... params) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set parameters
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            // Execute query
            ResultSet rs = pstmt.executeQuery();

            // Print results
            while (rs.next()) {
                System.out.println(rs.getString("your_column_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // This is just a sample. In a real application, you would likely not use this
        // method directly and would instead use Spring's dependency injection facilities.
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

        // Example: A valid query
        String validQuery = "SELECT * FROM users WHERE username = ?";
        String usernameToSearch = "valid_username";
        handler.executeQuery(validQuery, usernameToSearch);

        // Example: An injection query
        String injectionQuery = "SELECT * FROM users WHERE username = '"
                + injectionQuery + "'";
        String injection = "' OR '1'='1";
        handler.executeQuery(injectionQuery, injection);
    }
}