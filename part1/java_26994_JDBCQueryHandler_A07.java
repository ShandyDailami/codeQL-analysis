import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_26994_JDBCQueryHandler_A07 {

    public List<String> getAllEmployees() {
        List<String> employees = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3306/dbname";
            String username = "username";
            String password = "password";

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name FROM Employees");

            while (resultSet.next()) {
                employees.add(resultSet.getString("name"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}