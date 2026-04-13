import java.sql.*;

public class java_17062_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;

        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();

            // Create a new student
            String sql = "INSERT INTO student (id, name, age) VALUES (1, 'John', 25)";
            stmt.executeUpdate(sql);

            // Retrieve all students
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + ", " + name + ", " + age);
            }

            // Update a student
            sql = "UPDATE student SET name = 'Smith' WHERE id = 1";
            stmt.executeUpdate(sql);

            // Delete a student
            sql = "DELETE FROM student WHERE id = 1";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}