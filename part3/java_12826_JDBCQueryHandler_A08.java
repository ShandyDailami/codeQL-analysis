import java.sql.*;

public class java_12826_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        // Creating connection
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("Connection successful!");

            // Execute queries
            insertData(conn);
            selectData(conn);
        } catch (SQLException ex) {
            System.out.println("Connection failed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void insertData(Connection conn) {
        String query = "INSERT INTO myTable (name, age) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "John Doe");
            pstmt.setInt(2, 25);
            pstmt.executeUpdate();

            System.out.println("Inserted successfully!");
        } catch (SQLException ex) {
            System.out.println("Error while inserting: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void selectData(Connection conn) {
        String query = "SELECT * FROM myTable";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        } catch (SQLException ex) {
            System.out.println("Error while selecting: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}