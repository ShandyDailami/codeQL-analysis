import java.sql.*;
import java.util.Properties;

public class java_14349_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    private final String dbURL;
    private final String dbUsername;
    private final String dbPassword;

    public java_14349_JDBCQueryHandler_A07(String dbURL, String dbUsername, String dbPassword) {
        this.dbURL = dbURL;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
    }

    public void connectToDB() {
        try {
            Properties props = new Properties();
            props.setProperty("user", dbUsername);
            props.setProperty("password", dbPassword);
            conn = DriverManager.getConnection(dbURL, props);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Query Result: " + rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}