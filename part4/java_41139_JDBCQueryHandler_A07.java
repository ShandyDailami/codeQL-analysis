import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_41139_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_41139_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<String> executeQuery(String query) {
        List<String> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result.add(resultSet.getString("columnName"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return result;
    }
}