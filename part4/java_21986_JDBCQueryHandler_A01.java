import java.sql.*;

public class java_21986_JDBCQueryHandler_A01 {

    public static final String url = "jdbc:mysql://localhost:3306/db";
    public static final String user = "root";
    public static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id = " + 1);

            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}