import java.sql.*;

public class java_32883_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_32883_JDBCQueryHandler_A08(String dbURL, String dbUsername, String dbPassword) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
    }

    public void insertIntoTable(String tableName, String columns, String values) throws SQLException {
        String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void updateTable(String tableName, String setClause, String whereClause) throws SQLException {
        String sql = "UPDATE " + tableName + " SET " + setClause + " WHERE " + whereClause;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void deleteFromTable(String tableName, String whereClause) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE " + whereClause;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public ResultSet selectFromTable(String tableName, String selection) throws SQLException {
        String sql = "SELECT " + selection + " FROM " + tableName;
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}