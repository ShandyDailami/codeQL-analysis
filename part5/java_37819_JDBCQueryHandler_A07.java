import java.sql.*;

public class java_37819_JDBCQueryHandler_A07 {

    // define the database connection information
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn;
    private Statement stmt;

    public java_37819_JDBCQueryHandler_A07() {
        try {
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
            this.stmt = this.conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbc = new JDBCQueryHandler();
        jdbc.executeQuery("SELECT name FROM users WHERE password = 'password'");
    }
}