public class java_36255_CredentialValidator_A03 {

    public static class Info {
        public final String username;
        public final String password;

        public java_36255_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    public static class CredentialValidator implements javax.security.auth.login.CredentialValidator {

        private final Info info;

        public java_36255_CredentialValidator_A03(Info info) {
            this.info = info;
        }

        @Override
        public String getCallerName() {
            return "UNKNOWN";
        }

        @Override
        public Info getInfo() {
            return info;
        }

        @Override
        public boolean validate(Info info) {
            return this.info.username.equals(info.username) && this.info.password.equals(info.password);
        }
    }

    public static void main(String[] args) {
        Info info = new Info("admin", "password");
        CredentialValidator validator = new CredentialValidator(info);
        // Injection example:
        // CredentialValidator validator = new CredentialValidator(new Info(new Object() {
        //     public String username = "admin";
        //     public String password = "password";
        // }));
        System.out.println(validator.validate(info));
    }
}