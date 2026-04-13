import java.sql.*;

public class java_27241_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String selectQuery = "SELECT * FROM employees WHERE id = " + args[0];
            ResultSet resultSet = statement.executeQuery(selectQuery);

            if (resultSet.next()) {
                System.out.println("Found employee with id " + args[0]);
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
            } else {
                System.out.println("No employee found with id " + args[0]);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}