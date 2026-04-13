import java.sql.*;

public class java_03902_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_03902_JDBCQueryHandler_A08(String dbUrl, String userName, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl, userName, password);
    }

    public void createTable(String tableName) throws SQLException {
        String sql = "CREATE TABLE " + tableName + " (id INT PRIMARY KEY, name VARCHAR(50), age INT)";
        connection.createStatement().executeUpdate(sql);
    }

    public void insertIntoTable(String tableName, int id, String name, int age) throws SQLException {
        String sql = "INSERT INTO " + tableName + " (id, name, age) VALUES (" + id + ", '" + name + "', " + age + ")";
        connection.createStatement().executeUpdate(sql);
    }

    public ResultSet queryTable(String tableName, String query) throws SQLException {
        String sql = "SELECT * FROM " + tableName + " WHERE " + query;
        return connection.createStatement().executeQuery(sql);
    }

    public void updateTable(String tableName, String set, String where) throws SQLException {
        String sql = "UPDATE " + tableName + " SET " + set + " WHERE " + where;
        connection.createStatement().executeUpdate(sql);
    }

    public void deleteFromTable(String tableName, String where) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE " + where;
        connection.createStatement().executeUpdate(sql);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}