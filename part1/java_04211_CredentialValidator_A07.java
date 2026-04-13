import java.security.Principal;

public class java_04211_CredentialValidator_A07 implements javax.security.auth.login.CredentialValidator {

    @Override
    public Principal validate(javax.security.auth.Credential credential) {
        String name = credential.getCaller();
        if (name == null || name.isEmpty()) {
            return null;
        }
        return new MyPrincipal(name);
    }

    private class MyPrincipal implements Principal {

        private final String name;

        public java_04211_CredentialValidator_A07(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}