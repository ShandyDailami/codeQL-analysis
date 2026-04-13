import java.sql.*;

public class java_05769_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_05769_JDBCQueryHandler_A08(String dbUrl, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public void createTable(String tableName, String columns) throws SQLException {
        String sql = "CREATE TABLE " + tableName + " (" + columns + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    public void insertData(String tableName, String columns, String values) throws SQLException {
        String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + values + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    public ResultSet selectData(String tableName, String columns, String conditions) throws SQLException {
        String sql = "SELECT " + columns + " FROM " + tableName + " WHERE " + conditions;
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public void updateData(String tableName, String set, String conditions) throws SQLException {
        String sql = "UPDATE " + tableName + " SET " + set + " WHERE " + conditions;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    public void deleteData(String tableName, String conditions) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE " + conditions;
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}