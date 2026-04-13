import java.sql.*;

public class java_26926_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_26926_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        // Create a JDBCQueryHandler object with your database URL, username, and password
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

        // Execute a query
        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM mytable");

        // Print the result
        while (resultSet.next()) {
            System.out.println(resultSet.getString("column1") + ", " + resultSet.getString("column2"));
        }

        // Execute an update query
        int rowsAffected = jdbcQueryHandler.executeUpdate("UPDATE mytable SET column1 = 'new value' WHERE column2 = 'some value'");
        System.out.println("Number of rows affected: " + rowsAffected);
    }
}