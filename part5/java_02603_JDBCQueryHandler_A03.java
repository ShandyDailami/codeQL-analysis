import java.sql.*;

public class java_02603_JDBCQueryHandler_A03 {
    private String url;
    private String username;
    private String password;

    public java_02603_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String executeQuery(String query) {
        String result = "";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result += resultSet.getString(1);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        String result = handler.executeQuery("SELECT * FROM Users");
        System.out.println(result);
    }
}