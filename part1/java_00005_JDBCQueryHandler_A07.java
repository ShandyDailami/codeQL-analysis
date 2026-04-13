import java.sql.*;

public class java_00005_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/dbname";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM users WHERE email='" + args[0] + "' AND password='" + args[1] + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("User found");
            } else {
                System.out.println("User not found");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}