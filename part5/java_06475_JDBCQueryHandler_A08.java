import java.sql.*;

public class java_06475_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_06475_JDBCQueryHandler_A08(String url, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public void insertIntoTable(String tableName, String column1, String column2) throws SQLException {
        String sql = "INSERT INTO " + tableName + " (" + column1 + ", " + column2 + ") VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "data1");
        pstmt.setString(2, "data2");
        pstmt.executeUpdate();
    }

    public void updateColumn(String tableName, String column, String newValue, String condition) throws SQLException {
        String sql = "UPDATE " + tableName + " SET " + column + " = ? WHERE " + condition;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newValue);
        pstmt.executeUpdate();
    }

    public void deleteFromTable(String tableName, String condition) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE " + condition;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public ResultSet selectFromTable(String tableName, String condition) throws SQLException {
        String sql = "SELECT * FROM " + tableName + " WHERE " + condition;
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
}