import java.sql.*;

public class java_10897_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    private Connection conn = null;
    private Statement stmt = null;

    public void establishConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (stmt != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        if (conn == null) establishConnection();

        try {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Process the result set here
                System.out.println(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }
}