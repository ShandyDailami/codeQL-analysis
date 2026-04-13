import java.sql.*;
import org.mindrot.jbcrypt.*;

public class java_22170_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_22170_JDBCQueryHandler_A03(String dbUrl, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl, username, password);
    }

    public String hashPassword(String password) {
        return Bcrypt.hash(password, Bcrypt.gensalt(12));
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        return Bcrypt.check(password, hashedPassword);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String update) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(update);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}