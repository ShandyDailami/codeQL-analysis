import java.sql.*;

public class java_23965_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn = null;
    private Statement stmt = null;

    public java_23965_JDBCQueryHandler_A08() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error while connecting to database");
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Query returned: " + rs.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error while executing query");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler().executeQuery("SELECT * FROM my_table");
    }
}