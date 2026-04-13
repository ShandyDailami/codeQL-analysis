import java.sql.*;

public class java_04569_JDBCQueryHandler_A07 {
    private String url;
    private String username;
    private String password;

    public java_04569_JDBCQueryHandler_A07(String url, String username, String password) {
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
                System.out.println(resultSet.getString("columnName"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Replace with your actual URL, username, and password
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        handler.executeQuery("SELECT * FROM mytable");
    }
}