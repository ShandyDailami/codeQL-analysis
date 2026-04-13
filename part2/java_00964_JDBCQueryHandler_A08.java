import java.sql.*;

public class java_00964_JDBCQueryHandler_A08 {

    private Connection connection;

    public java_00964_JDBCQueryHandler_A08(String dbUrl, String userName, String password) {
        try {
            connection = DriverManager.getConnection(dbUrl, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void executeQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(result.getString("name"));
            }

            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Use the class
public class Main {
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
        handler.executeQuery("SELECT * FROM users WHERE role = ?");
    }
}