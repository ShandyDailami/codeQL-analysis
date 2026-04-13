import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_23492_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_23492_JDBCQueryHandler_A01(String dbUrl, String userName, String password) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> executeQuery(String query) {
        List<String> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a new instance of the JDBCQueryHandler
        JDBCQueryHandler queryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        // Execute a query
        List<String> result = queryHandler.executeQuery("SELECT * FROM my_table");
        for (String s : result) {
            System.out.println(s);
        }

        // Execute an update query
        queryHandler.executeUpdate("UPDATE my_table SET column1 = 'new_value' WHERE condition");
    }
}