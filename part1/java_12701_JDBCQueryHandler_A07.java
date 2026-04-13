import java.sql.*;

public class java_12701_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;

    public java_12701_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // TODO: process the result set
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // TODO: replace with your actual data
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(url, username, password);
        jdbcQueryHandler.executeQuery("SELECT * FROM your_table");
    }
}