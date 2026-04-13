import java.sql.*;

public class java_17258_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_17258_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String executeQuery(String query) {
        String result = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result += resultSet.getString(1) + " ";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        System.out.println(handler.executeQuery("SELECT * FROM Users"));
    }
}