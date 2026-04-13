import java.sql.*;

public class java_29248_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_29248_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnName1")
                    + " " + resultSet.getString("columnName2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // replace 'columnName1', 'columnName2', 'url', 'username', 'password' with actual values
        String query = "SELECT columnName1, columnName2 FROM tableName";
        new JDBCQueryHandler("url", "username", "password").executeQuery(query);
    }
}