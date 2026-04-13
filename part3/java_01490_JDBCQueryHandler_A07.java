import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01490_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/testDB";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void insertIntoTable(Connection conn, String query) {
        try {
            conn.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        Connection conn = handler.getConnection();
        String query = "INSERT INTO table1 (column1) VALUES ('data1')";
        handler.insertIntoTable(conn, query);
        conn.close();
    }
}