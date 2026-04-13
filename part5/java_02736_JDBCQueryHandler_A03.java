import java.sql.*;

public class java_02736_JDBCQueryHandler_A03 {

    // Database connection
    private Connection conn;

    public java_02736_JDBCQueryHandler_A03() {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("columnName"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Query failed");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler();
    }
}