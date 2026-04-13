import java.security.Principal;

public class java_07975_CredentialValidator_A03 {

    public Principal validate(String username, String password) {
        if (username == null || password == null) {
            return null;
        }

        if ("admin".equals(username) && "password".equals(password)) {
            return new Principal() {
                @Override
                public String getName() {
                    return username;
                }
            };
        }

        return null;
    }
}