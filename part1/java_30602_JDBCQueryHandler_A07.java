import java.sql.*;

public class java_30602_JDBCQueryHandler_A07 {

    // Database credentials
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    // A PreparedStatement can only be used once, and will not be closed automatically.
    // It's recommended to use a ResultSet instead.
    private static Connection connection;

    // Encapsulating the code in a method allows for better organization and testability
    // A method that closes a connection automatically on exit
    public static void execute(String query, ResultHandler handler) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = connection.prepareStatement(query, ResultSet.TYPE_FORWARD_ONLY);
            pstmt.setFetchSize(5); // Fetching 5 rows at a time
            pstmt.execute(handler);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try { connection.close(); }
                catch(SQLException e) { /* can't do anything, just ignore it */ }
            }
        }
    }

    // In this example, a ResultSet is used as the ResultHandler
    public static class UserResultSet implements ResultSetHandler {

        public Object handle(ResultSet rs) {
            List<User> users = new ArrayList<User>();
            try {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    users.add(user);
                }
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    }

    public static void main(String[] args) {
        // Use the handle method with a ResultSetHandler
        execute("SELECT * FROM Users", new UserResultSet());
    }

}