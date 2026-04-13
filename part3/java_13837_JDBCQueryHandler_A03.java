import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_13837_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public List<String> executeQuery(String query) {
        List<String> results = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                results.add(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        List<String> results = handler.executeQuery("SELECT * FROM my_table");
        for (String result : results) {
            System.out.println(result);
        }
    }
}