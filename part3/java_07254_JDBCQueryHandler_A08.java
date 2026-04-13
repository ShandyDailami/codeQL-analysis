import java.sql.*;

public class java_07254_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_07254_JDBCQueryHandler_A08(Connection conn) {
        this.conn = conn;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:your_db_url", "username", "password");
            JDBCQueryHandler jdbc = new JDBCQueryHandler(conn);
            ResultSet rs = jdbc.executeQuery("SELECT * FROM your_table");
            while (rs.next()) {
                System.out.println(rs.getString("your_column"));
            }
            jdbc.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}