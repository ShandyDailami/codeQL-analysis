import java.sql.*;

public class java_23547_JDBCQueryHandler_A08 {

    private String driverName;
    private String connectionURL;
    private String user;
    private String password;

    public java_23547_JDBCQueryHandler_A08(String driverName, String connectionURL, String user, String password) {
        this.driverName = driverName;
        this.connectionURL = connectionURL;
        this.user = user;
        this.password = password;
    }

    public void executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(connectionURL, user, password);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("Exception encountered in executeQuery: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error while closing connection: " + e.getMessage());
            }
        }
    }
}