import java.sql.*;

public class java_04660_JDBCQueryHandler_A01 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Open a connection to the database
    private Connection conn = null;

    // Open a statement for the database operation
    private Statement stmt = null;

    // SQL query
    private String query = null;

    public java_04660_JDBCQueryHandler_A01(String query) {
        this.query = query;
    }

    // Get a connection to the database
    public Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    // Execute the query
    public ResultSet executeQuery() {
        if (conn == null) {
            getConnection();
        }
        try {
            stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM Users";
        JDBCQueryHandler handler = new JDBCQueryHandler(sql);
        ResultSet rs = handler.executeQuery();

        try {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}