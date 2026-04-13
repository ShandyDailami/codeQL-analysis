import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_19951_JDBCQueryHandler_A07 {

    // private fields
    private Connection conn;
    private PreparedStatement stmt;

    // constructor
    public java_19951_JDBCQueryHandler_A07(String dbUrl, String user, String password) {
        try {
            // load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // create connection
            conn = DriverManager.getConnection(dbUrl, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // method to execute queries
    public ResultSet executeQuery(String query) {
        try {
            // create statement
            stmt = conn.prepareStatement(query);

            // execute query
            ResultSet rs = stmt.executeQuery();

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // method to close connection and statement
    public void close() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}