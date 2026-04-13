import java.sql.*;

public class java_22408_JDBCQueryHandler_A07 {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public java_22408_JDBCQueryHandler_A07() {
        initialize();
    }

    private void initialize() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
            processResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void processResultSet(ResultSet rs) {
        try {
            while (rs.next()) {
                // Process the result set here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users WHERE email = '" + args[0] + "' AND password = '" + args[1] + "'");
    }
}