import java.sql.*;

public class java_10494_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_10494_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void insertIntoTable(String tableName, String data) {
        String sql = "INSERT INTO " + tableName + " (column1) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, data);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in inserting data into table: " + e.getMessage());
        }
    }

    public ResultSet selectFromTable(String tableName) {
        String sql = "SELECT * FROM " + tableName;
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs;
        } catch (SQLException e) {
            System.out.println("Error in selecting data from table: " + e.getMessage());
            return null;
        }
    }

    public void updateTable(String tableName, String setStatement, String whereClause) {
        String sql = "UPDATE " + tableName + " SET " + setStatement + " WHERE " + whereClause;
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error in updating table: " + e.getMessage());
        }
    }

    public void deleteFromTable(String tableName, String whereClause) {
        String sql = "DELETE FROM " + tableName + " WHERE " + whereClause;
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error in deleting from table: " + e.getMessage());
        }
    }
}