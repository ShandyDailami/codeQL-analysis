import java.sql.*;

public class java_03827_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_03827_JDBCQueryHandler_A07(String dbURL, String userName, String password) {
        try {
            this.conn = DriverManager.getConnection(dbURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        String sql = "CREATE TABLE " + tableName + "(id INT PRIMARY KEY, name VARCHAR(50), age INT, salary DOUBLE)";

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoTable(int id, String name, int age, double salary) {
        String sql = "INSERT INTO " + tableName + "(id, name, age, salary) VALUES (" + id + ", '" + name + "', " + age + ", " + salary + ")";

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectFromTable(String whereClause) {
        String sql = "SELECT * FROM " + tableName + " WHERE " + whereClause;

        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateTable(String setClause, String whereClause) {
        String sql = "UPDATE " + tableName + " SET " + setClause + " WHERE " + whereClause;

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromTable(String whereClause) {
        String sql = "DELETE FROM " + tableName + " WHERE " + whereClause;

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}