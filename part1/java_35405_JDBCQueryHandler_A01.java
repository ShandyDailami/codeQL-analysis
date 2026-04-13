import java.sql.*;

public class java_35405_JDBCQueryHandler_A01 {
    private String url;
    private String username;
    private String password;

    public java_35405_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void readData() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM YourTable");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("YourColumn"));
            }
        } catch (SQLException e) {
            System.out.println("Error accessing the database: " + e.getMessage());
        }
    }
}