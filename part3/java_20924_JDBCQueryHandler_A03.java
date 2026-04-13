import java.sql.*;

public class java_20924_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM my_table WHERE my_column = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, "my_value"); // Assuming that the sensitive operation is to set the value

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Process the result set
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}