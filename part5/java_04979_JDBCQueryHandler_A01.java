import java.sql.*;

public class java_04979_JDBCQueryHandler_A01 {
    private Connection conn;
    private Statement stmt;

    public java_04979_JDBCQueryHandler_A01(String dbURL, String dbUsername, String dbPassword) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            this.conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            this.stmt = conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void queryHandler(String query) {
        try {
            // Prepare and execute the query
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Print the data in the result set
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Setup database connection
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/dbname", "username", "password");

        // Run query
        jdbcQueryHandler.queryHandler("SELECT * FROM users");
    }
}