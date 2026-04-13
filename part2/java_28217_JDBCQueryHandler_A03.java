import java.sql.*;

public class java_28217_JDBCQueryHandler_A03 {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpass";
    private static final String URL = "jdbc:mysql://localhost/test";

    public static void main(String[] args) {
        executeQuery("SELECT * FROM Users");
    }

    public static void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}