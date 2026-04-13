import java.sql.*;

public class java_14306_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE username = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "testuser");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("User Found");
                System.out.println("ID: " + result.getInt("id"));
                System.out.println("Username: " + result.getString("username"));
                System.out.println("Password: " + result.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}