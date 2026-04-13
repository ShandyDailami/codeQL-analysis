import java.sql.*;

public class java_25666_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:test.db"; // the database url

        try (Connection conn = DriverManager.getConnection(url)) {
            String sql = "SELECT * FROM AUTHENTICATION_FAILURE_TABLE"; // the SQL query

            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(sql); // execute the query

                // process the ResultSet
                while (rs.next()) {
                    System.out.println(rs.getString("username") + " " + rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}