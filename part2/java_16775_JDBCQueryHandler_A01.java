import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_16775_JDBCQueryHandler_A01 {

    // private fields
    private Connection conn;
    private Statement stmt;

    // constructor
    public java_16775_JDBCQueryHandler_A01(String dbURL, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbURL, user, password);
        stmt = conn.createStatement();
    }

    // methods for executing queries
    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    // methods for handling connections and statements
    public void closeConnection() throws SQLException {
        conn.close();
    }

    public void closeStatement() throws SQLException {
        stmt.close();
    }
}