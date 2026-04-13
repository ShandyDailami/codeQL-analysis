import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_28064_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "CREATE TABLE testTable (id INT PRIMARY KEY, name VARCHAR(100))";
            String insertSql = "INSERT INTO testTable (id, name) VALUES (?, ?)";
            String selectSql = "SELECT * FROM testTable WHERE id = ?";

            try (PreparedStatement createStmt = conn.prepareStatement(sql)) {
                createStmt.executeUpdate();
            }

            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setInt(1, 1);
                insertStmt.setString(2, "test");
                insertStmt.executeUpdate();

                insertStmt.setInt(1, 2);
                insertStmt.setString(2, "test2");
                insertStmt.executeUpdate();
            }

            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {
                selectStmt.setInt(1, 1);
                ResultSet rs = selectStmt.executeQuery();

                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}