import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class java_26816_SessionManager_A01 {
    private DataSource dataSource;

    public java_26816_SessionManager_A01(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveUser(User user) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = (Connection) dataSource.getConnection();
            stmt = (Statement) conn.prepareStatement("INSERT INTO Users (id, name, password) VALUES (?, ?, ?)");
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public User findUserById(int id) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = (Connection) dataSource.getConnection();
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Users WHERE id = " + id);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public List<User> findAllUsers() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<User> users = null;
        try {
            conn = (Connection) dataSource.getConnection();
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Users");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return users;
    }

    public void updateUser(User user) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = (Connection) dataSource.getConnection();
            stmt = (Statement) conn.prepareStatement("UPDATE Users SET name = ?, password = ? WHERE id = ?");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void deleteUser(int id) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = (Connection) dataSource.getConnection();
            stmt = (Statement) conn.prepareStatement("DELETE FROM Users WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}