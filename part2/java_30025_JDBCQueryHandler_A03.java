import java.sql.*;

public class java_30025_JDBCQueryHandler_A03 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    private static Connection connection;

    public static void main(String[] args) {

        try {
            connection = DriverManager.getConnection(url, username, password);

            String query1 = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt1 = connection.prepareStatement(query1);

            stmt1.setString(1, "test1");
            stmt1.setString(2, "password1");
            stmt1.executeUpdate();

            String query2 = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt2 = connection.prepareStatement(query2);

            stmt2.setString(1, "test1");
            ResultSet rs = stmt2.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("password"));
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}