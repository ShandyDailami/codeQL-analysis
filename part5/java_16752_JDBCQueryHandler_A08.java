import java.sql.*;

public class java_16752_JDBCQueryHandler_A08 {

    private Connection conn;
    private Statement stmt;

    private String dbURL;
    private String dbUser;
    private String dbPassword;

    public java_16752_JDBCQueryHandler_A08(String dbURL, String dbUser, String dbPassword) {
        this.dbURL = dbURL;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;

        try {
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Result: " + rs.getString("result"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error executing update: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
        handler.executeQuery("SELECT * FROM users");
    }
}