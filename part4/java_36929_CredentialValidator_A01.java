import javax.naming.*;
import javax.naming.spi.*;
import javax.naming.events.*;

public class java_36929_CredentialValidator_A01 implements CredentialValidator {

    private String userName;
    private String password;

    public java_36929_CredentialValidator_A01(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String getCallerName() throws NamingException {
        return this.getClass().getName();
    }

    @Override
    public String[] getInitials(String authority) throws NamingException {
        return new String[]{"C", "R", "U", "D"};
    }

    @Override
    public String getPassword(String userName) throws NamingException {
        return this.password;
    }

    @Override
    public String getUsername(String password) throws NamingException {
        return this.userName;
    }

    @Override
    public void setPassword(String password) throws NamingException {
        this.password = password;
    }

    @Override
    public void setUsername(String username) throws NamingException {
        this.userName = username;
    }

    @Override
    public void validate(Object context) throws NamingException {
        // no-op
    }

    @Override
    public void validate(Object context, NameEvent event) throws NamingException {
        // no-op
    }

    @Override
    public void close(NameContext context) throws NamingException {
        // no-op
    }

    @Override
    public void close(NameContext context, NameEvent event) throws NamingException {
        // no-op
    }

    @Override
    public boolean validate(NameEvent event) throws NamingException {
        // no-op
        return false;
    }

    @Override
    public boolean validate(NameEvent event, String password) throws NamingException {
        // no-op
        return false;
    }

    @Override
    public boolean validate(String username, String password) throws NamingException {
        if (this.userName.equals(username) && this.password.equals(password)) {
            return true;
        } else {
            throw new AuthenticationException("Invalid username or password");
        }
    }
}