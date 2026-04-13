import java.sql.*;

public class java_01913_JDBCQueryHandler_A03 {

    // This is the connection object
    private Connection conn = null;

    // This is the statement object
    private Statement stmt = null;

    // The constructor
    public java_01913_JDBCQueryHandler_A03() {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Set up the connection
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/testdb", "username", "password");

            // Set up the statement
            this.stmt = conn.createStatement();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    // This is the method that performs the query
    public ResultSet executeQuery(String query) {
        try {
            // Perform the query
            ResultSet rs = stmt.executeQuery(query);

            // Return the result set
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        // Return null
        return null;
    }

    // This is the method that performs the update
    public int executeUpdate(String query) {
        try {
            // Perform the update
            return stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        // Return 0
        return 0;
    }

    // This is the method that closes the connection
    public void close() {
        try {
            // Close the statement
            stmt.close();

            // Close the connection
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}