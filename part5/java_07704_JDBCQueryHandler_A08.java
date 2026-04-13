import java.sql.*;

public class java_07704_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_07704_JDBCQueryHandler_A08(String dbURL, String username, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName, String columns) {
        String query = "CREATE TABLE " + tableName + " (" + columns + ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(String tableName, String values) {
        String query = "INSERT INTO " + tableName + " VALUES (" + values + ")";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectData(String tableName) {
        String query = "SELECT * FROM " + tableName;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("columnName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(String tableName, String set, String where) {
        String query = "UPDATE " + tableName + " SET " + set + " WHERE " + where;
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String tableName, String where) {
        String query = "DELETE FROM " + tableName + " WHERE " + where;
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}