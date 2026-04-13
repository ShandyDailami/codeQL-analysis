import java.sql.*;

public class java_02960_JDBCQueryHandler_A08 {
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/testdb?useSSL=false", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // Query 1
            String query1 = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement1 = connection.prepareStatement(query1);
            statement1.setInt(1, 1);
            ResultSet result1 = statement1.executeQuery();

            // Query 2
            String query2 = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement2 = connection.prepareStatement(query2);
            statement2.setInt(1, 2);
            ResultSet result2 = statement2.executeQuery();

            // Query 3
            String query3 = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement3 = connection.prepareStatement(query3);
            statement3.setInt(1, 3);
            ResultSet result3 = statement3.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}