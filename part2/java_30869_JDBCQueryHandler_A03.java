import java.sql.*;

public class java_30869_JDBCQueryHandler_A03 {
    // private fields for database credentials
    private String url;
    private String username;
    private String password;

    // constructor
    public java_30869_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // method for executing a SQL query
    public ResultSet executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

            // execute the query and get the ResultSet
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close the database resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* ignored */ }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { /* ignored */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* ignored */ }
            }
        }

        return rs;
    }

    // example usage
    public static void main(String[] args) {
        // replace with your actual database credentials
        String url = "jdbc:mysql://localhost/test";
        String username = "user";
        String password = "password";

        // create a new instance of the handler
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler(url, username, password);

        // execute a SQL query
        ResultSet rs = handler.executeQuery("SELECT * FROM users");

        // print the results
        while (rs.next()) {
            System.out.println("Username: " + rs.getString("username"));
            System.out.println("Password: " + rs.getString("password"));
        }
    }
}