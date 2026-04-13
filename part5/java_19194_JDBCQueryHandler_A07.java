import java.sql.*;

public class java_19194_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                String sql = "SELECT role FROM users WHERE username = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, "user1");
                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    String role = result.getString("role");
                    if ("Admin".equals(role)) {
                        System.out.println("User is admin");
                    } else {
                        System.out.println("User is not admin");
                    }
                }

                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver is not available in the classpath");
            return null;
        }
    }
}