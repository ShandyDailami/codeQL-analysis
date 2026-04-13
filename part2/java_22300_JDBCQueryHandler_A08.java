import java.sql.*;

public class java_22300_JDBCQueryHandler_A08 {
    private Connection connection;

    public java_22300_JDBCQueryHandler_A08(String dbUrl, String userName, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, userName, password);
    }

    public void deleteRow(String tableName, String columnName, String columnValue) {
        String sql = "DELETE FROM " + tableName + " WHERE " + columnName + " = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, columnValue);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Deleted " + affectedRows + " row(s) from " + tableName);
            } else {
                System.out.println("No row found to delete in " + tableName);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting row from " + tableName + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password").deleteRow("users", "id", "1");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}