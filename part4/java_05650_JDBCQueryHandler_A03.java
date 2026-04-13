import java.sql.*;

public class java_05650_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_05650_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String executeQuery(String query) {
        String result = null;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result = resultSet.getString(1); // Assuming the result is a string
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
        String result = handler.executeQuery("SELECT * FROM mytable");
        System.out.println(result);
    }
}