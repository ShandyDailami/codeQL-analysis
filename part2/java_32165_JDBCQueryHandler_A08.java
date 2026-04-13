import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_32165_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM my_table";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                double column3 = resultSet.getDouble("column3");
                // etc...

                System.out.println("column1: " + column1);
                System.out.println("column2: " + column2);
                System.out.println("column3: " + column3);
                // etc...
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}