import java.sql.*;

public class java_17287_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_17287_JDBCQueryHandler_A07(String url, String username, String password) {
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
        connection.close();
    }

    public static void main(String[] args) {
        // You need to replace these placeholders with your actual data
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);

        String query = "SELECT * FROM my_table";

        try {
            ResultSet resultSet = handler.executeQuery(query);

            while (resultSet.next()) {
                // Prints the data in the result set
                System.out.println(resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}