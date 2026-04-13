import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_06145_JDBCQueryHandler_A01 {

    private final Connection connection;

    public java_06145_JDBCQueryHandler_A01(String dbURL, String userName, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, userName, password);
    }

    public List<User> getUsersByRole(String role) throws SQLException {
        List<User> users = new ArrayList<>();

        String query = "SELECT * FROM Users WHERE role = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, role);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setRole(rs.getString("role"));
            users.add(user);
        }

        rs.close();
        stmt.close();

        return users;
    }

    public static class User {
        private int id;
        private String name;
        private String role;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}