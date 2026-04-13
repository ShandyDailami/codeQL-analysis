import java.sql.*;
import java.util.Properties;

public class java_30988_JDBCQueryHandler_A08 {
    private Connection conn = null;

    public java_30988_JDBCQueryHandler_A08() {
        establishConnection();
    }

    private void establishConnection() {
        Properties props = new Properties();
        try {
            props.load(getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
            Class.forName(props.getProperty("driver"));
            conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users WHERE role = 'admin'");
    }
}