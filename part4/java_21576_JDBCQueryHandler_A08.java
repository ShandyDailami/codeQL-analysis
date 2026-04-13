import java.sql.*;

public class java_21576_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM Employees";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("ID"));
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("Salary: " + resultSet.getString("Salary"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in accessing the database: " + e.getMessage());
        }
    }
}