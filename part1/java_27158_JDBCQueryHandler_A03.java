import java.sql.*;
import java.util.Properties;

public class java_27158_JDBCQueryHandler_A03 {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connectDB() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("/database.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public void disconnectDB() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.connectDB();
        jdbcQueryHandler.executeQuery("SELECT * FROM table_name"); // Replace with your query
        jdbcQueryHandler.disconnectDB();
    }
}