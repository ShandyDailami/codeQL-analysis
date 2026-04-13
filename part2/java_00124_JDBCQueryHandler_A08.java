import java.sql.*;

public class java_00124_JDBCQueryHandler_A08 {
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String connectionURL = "jdbc:mysql://localhost:3306/mydatabase";
    private String username = "root";
    private String password = "password";

    private Connection con = null;
    private Statement stmt = null;

    public java_00124_JDBCQueryHandler_A08() {
        initialize();
    }

    private void initialize() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(connectionURL, username, password);
            stmt = con.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String query) {
        int updateCount = 0;
        try {
            updateCount = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateCount;
    }
}