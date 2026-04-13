import java.sql.*;

public class java_04272_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    private static Connection conn;
    private static PreparedStatement pstmt;

    public static void main(String[] args) {
        openConnection();
        executeQuery();
        closeConnection();
    }

    private static void openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to database!");
        } catch (Exception e) {
            System.out.println("Failed to connect to database!");
            e.printStackTrace();
        }
    }

    private static void executeQuery() {
        try {
            pstmt = conn.prepareStatement("SELECT * FROM your_table_name WHERE your_condition");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute query!");
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Failed to close connection!");
            e.printStackTrace();
        }
    }
}