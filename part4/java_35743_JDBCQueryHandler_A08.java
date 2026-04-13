import java.sql.*;
import java.util.Properties;

public class java_35743_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_35743_JDBCQueryHandler_A08() {
        try {
            Properties props = new Properties();
            props.setProperty("user", "root");
            props.setProperty("password", "password");
            props.setProperty("useSSL", "false");
            props.setProperty("autoReconnect", "true");
            props.setProperty("databaseName", "test");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", props);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM table_name");
    }
}