import java.sql.*;

public class java_23721_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            String sql = "SELECT password FROM Users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "testuser");
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String password = result.getString("password");
                System.out.println("Password is: " + password);
            } else {
                System.out.println("No user with that username found!");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while trying to access the database: " + e.getMessage());
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("Error occurred while trying to load the database driver: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}