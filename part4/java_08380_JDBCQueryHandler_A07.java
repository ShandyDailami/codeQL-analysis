import java.sql.*;

public class java_08380_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM users WHERE id = " + args[0];
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("User id: " + resultSet.getInt("id"));
                System.out.println("User name: " + resultSet.getString("name"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}