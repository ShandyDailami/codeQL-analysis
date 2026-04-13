import java.sql.*;

public class java_38539_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_38539_JDBCQueryHandler_A03() {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/testdb",
                    "username",
                    "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Prepare statement
            Statement stmt = conn.createStatement();

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

            // Process result set
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
            }

            // Close connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users WHERE name='" + args[0] + "'");
    }
}