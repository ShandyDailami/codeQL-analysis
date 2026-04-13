import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_27875_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "username";
            String password = "password";

            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM my_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");
                // Do something with the data
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}