import java.sql.*;

public class java_11360_JDBCQueryHandler_A08 {
    private String url;
    private String username;
    private String password;

    public java_11360_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("fieldName1") + " - " + resultSet.getString("fieldName2"));
            }
        } catch (SQLException e) {
            System.out.println("Error in query execution: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Replace with your actual values
        String url = "jdbc:your_driver:your_url";
        String username = "your_username";
        String password = "your_password";

        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler(url, username, password);
        jdbcQueryHandler.executeQuery("SELECT fieldName1, fieldName2 FROM your_table");
    }
}