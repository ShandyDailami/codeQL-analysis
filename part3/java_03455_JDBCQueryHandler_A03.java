import java.sql.*;

public class java_03455_JDBCQueryHandler_A03 {
    // define the database connection
    private Connection conn = null;

    // define the database URL and username/password
    private final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private final String USER = "root";
    private final String PASS = "password";

    // establish the connection
    public java_03455_JDBCQueryHandler_A03() {
        initializeDatabaseConnection();
    }

    private void initializeDatabaseConnection() {
        try {
            // load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // define a method to execute a select query
    public ResultSet executeSelectQuery(String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // define a method to execute an update or delete query
    public int executeUpdateQuery(String query) {
        Statement stmt = null;
        int rowsUpdated = 0;
        try {
            stmt = conn.createStatement();
            rowsUpdated = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    // define a method to execute an insert query
    public int executeInsertQuery(String query) {
        Statement stmt = null;
        int rowsInserted = 0;
        try {
            stmt = conn.createStatement();
            rowsInserted = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
    }

    // close the connection
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Disconnected from the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}