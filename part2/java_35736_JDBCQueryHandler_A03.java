import java.sql.*;

public class java_35736_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM users WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "John Doe");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String name = result.getString("name");
                System.out.println("Name: " + name);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}