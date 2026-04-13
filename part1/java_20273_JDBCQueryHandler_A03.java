import java.sql.*;

public class java_20273_JDBCQueryHandler_A03 {
    // private fields for connection and statement
    private Connection conn;
    private Statement stmt;

    // constructor
    public java_20273_JDBCQueryHandler_A03(String dbURL, String user, String pass) {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish connection
            this.conn = DriverManager.getConnection(dbURL, user, pass);

            // Open a statement
            this.stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Handle the result set
            while (rs.next()) {
                // Print the data
                System.out.println(rs.getString("column_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // main method
    public static void main(String[] args) {
        // Set database credentials
        String dbURL = "jdbc:mysql://localhost:3306/mydb";
        String user = "username";
        String pass = "password";

        // Create the handler
        JDBCQueryHandler handler = new JDBCQueryHandler(dbURL, user, pass);

        // Execute a query
        handler.executeQuery("SELECT * FROM my_table");
    }
}