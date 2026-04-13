import java.sql.*;
import java.util.Properties;

public class java_41374_JDBCQueryHandler_A07 {
    private static Connection connection = null;

    static Connection connectToDatabase(String dbURL, String userName, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", userName);
            props.setProperty("password", password);
            props.setProperty("characterEncoding", "utf-8");

            connection = DriverManager.getConnection(dbURL, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    static ResultSet executeQuery(Connection connection, String query) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    static int executeUpdate(Connection connection, String query) {
        PreparedStatement statement = null;
        int rowsUpdated = 0;
        try {
            statement = connection.prepareStatement(query);
            rowsUpdated = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/mydatabase";
        String userName = "root";
        String password = "password";

        connectToDatabase(dbURL, userName, password);
        String query = "SELECT * FROM my_table";
        ResultSet resultSet = executeQuery(connection, query);

        // print out the result set
        while (resultSet.next()) {
            System.out.println(resultSet.getString("column_name"));
        }

        // execute an update query
        String updateQuery = "UPDATE my_table SET column1 = 'new_value' WHERE column2 = 'some_value'";
        executeUpdate(connection, updateQuery);
    }
}