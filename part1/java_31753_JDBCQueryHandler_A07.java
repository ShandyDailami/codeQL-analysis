import java.sql.*;
import java.util.Properties;

public class java_31753_JDBCQueryHandler_A07 {
    private Connection conn;

    public void connectToDB(String url, String username, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);

            conn = DriverManager.getConnection(url, props);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbc = new JDBCQueryHandler();
        jdbc.connectToDB("url", "username", "password");
        jdbc.executeQuery("SELECT * FROM table");
        jdbc.closeConnection();
    }
}