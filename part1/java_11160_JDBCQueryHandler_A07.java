import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_11160_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // JDBC API connection
    private Connection conn;

    public java_11160_JDBCQueryHandler_A07() {
        try {
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a SELECT query
    public List<String> getData(String tableName) {
        List<String> dataList = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                dataList.add(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    // Method to execute a INSERT query
    public void insertData(String tableName, String columnName, String data) {
        String sql = "INSERT INTO " + tableName + " (" + columnName + ") VALUES (?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a UPDATE query
    public void updateData(String tableName, String columnName, String newData, String conditionColumn, String conditionValue) {
        String sql = "UPDATE " + tableName + " SET " + columnName + " = ? WHERE " + conditionColumn + " = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newData);
            pstmt.setString(2, conditionValue);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a DELETE query
    public void deleteData(String tableName, String columnName, String conditionValue) {
        String sql = "DELETE FROM " + tableName + " WHERE " + columnName + " = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, conditionValue);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // Example usage: get data from a table
        List<String> data = handler.getData("users");
        System.out.println(data);

        // Example usage: insert a new row into a table
        handler.insertData("users", "username", "newuser");

        // Example usage: update a row in a table
        handler.updateData("users", "email", "newemail@example.com", "username", "olduser");

        // Example usage: delete a row from a table
        handler.deleteData("users", "username", "olduser");
    }
}