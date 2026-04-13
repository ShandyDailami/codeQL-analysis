import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_18125_JDBCQueryHandler_A01 {
    private static Connection conn = null;
    private static Statement stmt = null;

    // Connect to database
    static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
            stmt = conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Query execution
    static List<String> executeQuery(String query) {
        List<String> result = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString("column_name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    // Main method
    public static void main(String[] args) {
        connect();
        List<String> results = executeQuery("SELECT * FROM table_name");
        for (String result : results) {
            System.out.println(result);
        }
    }
}