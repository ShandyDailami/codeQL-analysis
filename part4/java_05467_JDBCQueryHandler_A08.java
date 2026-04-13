import java.sql.*;

public class java_05467_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_05467_JDBCQueryHandler_A08(String dbUrl, String user, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(String username) {
        String query = "SELECT * FROM Users WHERE Username = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");
        System.out.println(handler.checkUser("user1"));
    }
}