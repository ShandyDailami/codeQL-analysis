import java.sql.*;

public class java_06566_JDBCQueryHandler_A08 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
           
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while connecting to MySQL database: " + e.getMessage());
        }
    }
}