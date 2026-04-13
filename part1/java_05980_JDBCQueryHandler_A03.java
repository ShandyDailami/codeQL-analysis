import java.sql.*;

public class java_05980_JDBCQueryHandler_A03 {

    private Connection conn;

    public java_05980_JDBCQueryHandler_A03() {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void performQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Print out the results
            while (rs.next()) {
                System.out.println(rs.getString("columnName"));
            }

            // Close the ResultSet and Statement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.performQuery("SELECT * FROM myTable");
    }
}