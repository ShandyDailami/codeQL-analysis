import java.sql.*;

public class java_17494_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            //Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            //Step 2: Prepare a statement
            Statement stmt = conn.createStatement();

            //Step 3: Execute a query
            String sql = "SELECT * FROM Users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 123); //You can replace 123 with any id

            ResultSet rs = pstmt.executeQuery();

            //Step 4: Process the result
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            //Step 5: Close the resources
            rs.close();
            pstmt.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}