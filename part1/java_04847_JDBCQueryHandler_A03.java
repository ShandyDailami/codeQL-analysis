import java.sql.*;

public class java_04847_JDBCQueryHandler_A03 {
    private static final String DB_URL = "your_db_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    private Connection conn;

    public java_04847_JDBCQueryHandler_A03() {
        connectToDB();
    }

    private void connectToDB() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public void executeQuery(String query) {
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    // Here you can perform operations on the result set
                    System.out.println("Result: " + rs.getString("your_column_name"));
                }

                rs.close();
                stmt.close();

            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }
        } else {
            System.out.println("Error: Database connection was null");
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM your_table");
    }
}