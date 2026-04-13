import java.sql.*;

public class java_12248_JDBCQueryHandler_A03 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASS = "password";

    private static Connection connection = null;

    static {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String query = "SELECT * FROM my_table";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Extract data from ResultSet
            while (rs.next()) {
                System.out.println(rs.getString("my_column"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}