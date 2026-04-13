import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_11291_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:your_database_url";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            String query = "SELECT * FROM your_table";
            ResultSet resultSet = statement.executeQuery(query);

            List<YourModel> dataList = new ArrayList<>();
            while (resultSet.next()) {
                YourModel data = new YourModel();
                data.setId(resultSet.getInt("id"));
                data.setName(resultSet.getString("name"));
                dataList.add(data);
            }

            // Print data
            for (YourModel data : dataList) {
                System.out.println("ID: " + data.getId() + ", Name: " + data.getName());
            }

            // Close connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}