import java.sql.*;

public class java_16294_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn = null;
    private Statement stmt = null;

    // Constructor
    public java_16294_JDBCQueryHandler_A03() {
        initialize();
    }

    // Method to initialize connections
    private void initialize() {
        try {
            // Load the Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // create a statement
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to fetch data
    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            // execute the query
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Method to update data
    public int executeUpdate(String query) {
        int rowsUpdated = 0;
        try {
            // execute the query
            rowsUpdated = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    // Method to close connections
    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}