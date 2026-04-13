import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_10405_JDBCQueryHandler_A08 {

    // This is the URL to connect to the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // These are the login credentials for the database
    private static final String USER = "username";
    private static final String PASS = "password";

    public List<String> executeQuery(String query) {
        List<String> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Extract data from ResultSet
            while (rs.next()) {
                results.add(rs.getString(1)); // Assuming the first column is the data you want
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        List<String> result = handler.executeQuery("SELECT * FROM my_table");
        for (String s : result) {
            System.out.println(s);
        }
    }
}