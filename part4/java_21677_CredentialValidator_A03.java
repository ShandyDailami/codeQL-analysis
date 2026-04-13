import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.callback.CredentialCallback;
import javax.security.auth.callback.CredentialCallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_21677_CredentialValidator_A03 implements CredentialCallbackHandler {

    private String url;
    private String username;
    private String password;

    public java_21677_CredentialValidator_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public CredentialCallbackHandler prepareCall(CredentialCallback c) throws UnsupportedCallbackException {
        return this;
    }

    @Override
    public CredentialCallbackHandler validate(CredentialCallback c) throws UnsupportedCallbackException {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT 1 FROM USERS WHERE USERNAME = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, c.getCredentialIdentifier());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                c.setCredential(c.getCredentialIdentifier());
            } else {
                throw new IllegalArgumentException("Invalid username or password");
            }
            c.setEnabled(true);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Invalid username or password", e);
        }
        return this;
    }

}