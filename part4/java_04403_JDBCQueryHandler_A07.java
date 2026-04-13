import java.sql.*;

public class java_04403_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_04403_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public static void main(String[] args) {
        // Replace with your actual values
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            JDBCQueryHandler queryHandler = new JDBCQueryHandler(url, username, password);
            ResultSet resultSet = queryHandler.executeQuery("SELECT * FROM my_table");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }

            queryHandler.executeUpdate("UPDATE my_table SET column1 = 'new_value' WHERE column2 = 'old_value'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}