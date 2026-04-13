import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_25763_JDBCQueryHandler_A08 {

    // Define your database URL, username and password here.
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        List<String> names = getNames();
        if (names != null) {
            for (String name : names) {
                System.out.println(name);
            }
        }
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT name FROM my_table");
            while (resultSet.next()) {
                names.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }
}