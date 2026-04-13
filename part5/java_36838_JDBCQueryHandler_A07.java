import java.sql.*;

public class java_36838_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}