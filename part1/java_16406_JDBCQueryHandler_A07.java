import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_16406_JDBCQueryHandler_A07 {

    private Connection conn;

    public void connectToDatabase(String databaseUrl, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(databaseUrl, username, password);
    }

    public boolean verifyUserCredentials(String username, String password) throws SQLException {
        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
        connectToDatabase("jdbc:mysql://localhost:3306/mydb", "username", "password");

        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }
}