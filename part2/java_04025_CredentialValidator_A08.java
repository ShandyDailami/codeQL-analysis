import java.util.function.Function;

public class java_04025_CredentialValidator_A08 implements Function<Credential, Boolean> {
    public Boolean apply(Credential credential) {
        return "admin".equals(credential.getUsername()) && "password".equals(credential.getPassword());
    }

    public static class Credential {
        private String username;
        private String password;

        public java_04025_CredentialValidator_A08(String username, String password) {
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

    public static void main(String[] args) {
        Credential credential = new Credential("admin", "password");
        CredentialValidator validator = new CredentialValidator();

        if (validator.apply(credential)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}