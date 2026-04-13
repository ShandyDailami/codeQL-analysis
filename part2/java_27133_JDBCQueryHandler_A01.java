import java.sql.*;
import java.util.Properties;

public class java_27133_JDBCQueryHandler_A01 {

    // Method to get the database connection
    private Connection getConnection() {
        Connection conn = null;
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String passwordManager = props.getProperty("passwordManager");
            String password = passwordManager.split(":")[1];

            String url = props.getProperty("db.url");
            String driver = props.getProperty("db.driver");

            conn = DriverManager.getConnection(url, "username", password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Method to perform a query
    public void performQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("Name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.performQuery("SELECT * FROM Employee");
    }
}