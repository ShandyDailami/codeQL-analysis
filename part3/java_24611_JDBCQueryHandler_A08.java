import java.sql.*;

public class java_24611_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            String sql = "SELECT users.user_id, users.user_name, roles.role_name " +
                    "FROM users " +
                    "INNER JOIN roles ON users.role_id = roles.role_id";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String userId = resultSet.getString("user_id");
                String userName = resultSet.getString("user_name");
                String roleName = resultSet.getString("role_name");

                System.out.println("User ID: " + userId);
                System.out.println("User Name: " + userName);
                System.out.println("Role Name: " + roleName);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}