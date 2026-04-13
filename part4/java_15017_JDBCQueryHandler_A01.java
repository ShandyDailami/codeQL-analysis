import java.sql.*;

public class java_15017_JDBCQueryHandler_A01 {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // Insert query
            String sqlInsert = "INSERT INTO myTable (name, age) VALUES ('John', 30)";
            stmt.executeUpdate(sqlInsert);

            // Select query
            String sqlSelect = "SELECT * FROM myTable WHERE age > 30";
            ResultSet rs = stmt.executeQuery(sqlSelect);

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
           
            }
            rs.close();

            // Delete query
            String sqlDelete = "DELETE FROM myTable WHERE name='John'";
            stmt.executeUpdate(sqlDelete);

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }
}