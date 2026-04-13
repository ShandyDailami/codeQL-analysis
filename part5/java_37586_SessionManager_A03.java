import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.AuthenticationService;
import javax.security.auth.spi.LoginModule;

public class java_37586_SessionManager_A03 implements AuthenticationService, LoginModule {

    private String username;
    private String password;
    private Connection connection;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean validate(Subject subject, String password) {
        this.password = password;
        return true;
    }

    public Connection getConnection(String username, String password) {
        this.username = username;
        this.password = password;
        return connection;
    }

    public void login() throws LoginException {
        try {
            Properties props = new Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);
            props.setProperty("useSSL", "false");
            props.setProperty("autoReconnect", "true");
            props.setProperty("characterSet", "utf8");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", props);
            this.connection = conn;
        } catch (SQLException e) {
            throw new LoginException("Authentication failed");
        }
    }

    public boolean commit() throws LoginException {
        return true;
    }

    public boolean abort() throws LoginException {
        return true;
    }

    public void initialize(Subject subject, Properties props) throws LoginException {
        // Not used, but required by login service
    }

    public void cleanup(Subject subject, Properties props) throws LoginException {
        // Not used, but required by login service
    }
}