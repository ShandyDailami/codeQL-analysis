public class java_33294_CredentialValidator_A01 {

    public Credential validate(String username, String password) throws AccessDeniedException {
        if ("admin".equals(username) && "password".equals(password)) {
            return new Credential(username, password);
        } else {
            throw new AccessDeniedException("Invalid username or password.");
        }
    }

    public static class Credential {
        private String username;
        private String password;

        public java_33294_CredentialValidator_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class AccessDeniedException extends Exception {
        public java_33294_CredentialValidator_A01(String message) {
            super(message);
        }
    }
}