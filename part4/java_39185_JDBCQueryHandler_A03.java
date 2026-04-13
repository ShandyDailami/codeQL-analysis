import java.sql.*;

public class java_39185_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String selectQuery = "SELECT * FROM Employees WHERE Department = 'Sales'";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                String position = resultSet.getString("Position");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Position: " + position);
                System.out.println("-------------");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}