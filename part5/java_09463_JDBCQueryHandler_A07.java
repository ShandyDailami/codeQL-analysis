import java.sql.*;
import java.util.Properties;

public class java_09463_JDBCQueryHandler_A07 {

    private static Connection conn;
    private static Statement stmt;

    static {
        Properties props = new Properties();
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM TABLENAME";
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("columnName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}