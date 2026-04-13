import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class java_13596_SessionManager_A08 implements AuthenticationService, LoginModule {
    private List<Principal> principals = new ArrayList<>();
    private List<Principal> groups = new ArrayList<>();
    private String username = null;
    private String password = null;

    @Override
    public boolean validate(Subject subject, Principal principal) throws LoginException {
        if (principal == null) {
            return false;
        }
        this.username = principal.getName();
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public boolean abort(Subject subject) throws LoginException {
        return true;
    }

    @Override
    public boolean establish(Subject subject, CallbackHandler callbackHandler, Principal principal) throws LoginException {
        this.principals = new ArrayList<>();
        this.principals.add(principal);
        return true;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user", "password");
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}