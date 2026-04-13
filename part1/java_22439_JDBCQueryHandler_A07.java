import java.sql.*;

public class java_22439_JDBCQueryHandler_A07 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Create a connection
    private Connection conn = null;

    public java_22439_JDBCQueryHandler_A07() {
        try {
            // Load MySQL driver
            Class.forName(DB_DRIVER);

            // Open a connection
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Unable to load driver");
            e.printStackTrace();
        }
    }

    // Define a query to execute
    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            Statement stmt = this.conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error: Unable to execute query");
            e.printStackTrace();
        }
        return rs;
    }

    // Define a statement to execute
    public int executeUpdate(String query) {
        int rowsUpdated = 0;
        try {
            Statement stmt = this.conn.createStatement();
            rowsUpdated = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error: Unable to execute update query");
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    // Close connection
    public void closeConnection() {
        try {
            if (this.conn != null && !this.conn.isClosed()) {
                this.conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to close connection");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // create an object of JDBCQueryHandler
        JDBCQueryHandler queryHandler = new JDBCQueryHandler();

        // Execute a query
        ResultSet rs = queryHandler.executeQuery("SELECT * FROM Users");

        // Process the result set
        while (rs.next()) {
            // Handle each record
            String username = rs.getString("username");
            String password = rs.getString("password");

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }

        // Close the connection
        queryHandler.closeConnection();
    }
}