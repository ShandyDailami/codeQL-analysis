import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_33709_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_33709_JDBCQueryHandler_A01() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getUserRoles(String user) {
        List<String> roles = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT role FROM Users WHERE username = ?");
            statement.setString(1, user);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                roles.add(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        List<String> roles = handler.getUserRoles("user1");
        for (String role : roles) {
            System.out.println(role);
        }
    }
}