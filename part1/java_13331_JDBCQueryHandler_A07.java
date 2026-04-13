import java.sql.*;

public class java_13331_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;
    private String url;
    private String username;
    private String password;

    public java_13331_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a JDBCQueryHandler instance and connect to the database
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
        handler.connect();

        // Execute a query
        String query = "SELECT * FROM Users";
        ResultSet result = handler.executeQuery(query);

        // Process the result set
        while (result.next()) {
            String name = result.getString("name");
            // TODO: Perform some operation with the user data
        }

        // Disconnect from the database
        handler.disconnect();
    }
}