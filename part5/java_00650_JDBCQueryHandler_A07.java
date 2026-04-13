import java.sql.*;

public class java_00650_JDBCQueryHandler_A07 {

    private Connection conn;
    private Statement stmt;

    public java_00650_JDBCQueryHandler_A07(String dbUrl, String username, String password) {
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Replace with your actual database details
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        JDBCAuthFailureExample example = new JDBCAuthFailureExample(dbUrl, username, password);

        // Example query
        String query = "SELECT * FROM Users WHERE username = 'admin' AND password = 'password'";

        example.executeQuery(query);
    }
}