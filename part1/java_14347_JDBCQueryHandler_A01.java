import java.sql.*;

public class java_14347_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE role = 'admin'");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                System.out.println("Name: " + name + ", Role: " + role);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}