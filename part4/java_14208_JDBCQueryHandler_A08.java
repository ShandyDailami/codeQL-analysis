import java.sql.*;
import java.util.Properties;

public class java_14208_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_14208_JDBCQueryHandler_A08() {
        try {
            Properties props = new Properties();
            props.load(getClass().getResourceAsStream("/db.properties"));
            conn = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void execute(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Process the result set
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}