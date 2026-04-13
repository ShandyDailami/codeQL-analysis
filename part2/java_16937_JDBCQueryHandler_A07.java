import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_16937_JDBCQueryHandler_A07 {
    private UserDao userDao;

    public java_16937_JDBCQueryHandler_A07(UserDao userDao) {
        this.userDao = userDao;
    }

    public User authenticateUser(String username, String password) {
        User user = userDao.findUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            throw new AuthFailureException("Authentication failed");
        }
    }
}