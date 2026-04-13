import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_26933_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<String> getAllData() {
        List<String> data = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table")) {
            while (resultSet.next()) {
                data.add(resultSet.getString("my_column"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void insertData(String data) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO my_table (my_column) VALUES (?)")) {
            statement.setString(1, data);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String data) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM my_table WHERE my_column = ?")) {
            statement.setString(1, data);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        // Get all data
        System.out.println("All data: " + handler.getAllData());
        // Insert data
        handler.insertData("Inserted data");
        // Get all data again
        System.out.println("All data after insertion: " + handler.getAllData());
        // Delete data
        handler.deleteData("Inserted data");
        // Get all data again
        System.out.println("All data after deletion: " + handler.getAllData());
    }
}