import java.sql.*;

public class java_36663_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_36663_JDBCQueryHandler_A03(String url, String username, String password) {
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
                System.out.println(resultSet.getString("column1"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // You would typically put your own SQL server details in a secure way, such as environment variables
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        handler.executeQuery("SELECT * FROM mytable");
    }
}