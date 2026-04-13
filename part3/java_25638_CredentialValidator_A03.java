public class java_25638_CredentialValidator_A03 {

    public static class Credentials {
        private String username;

        public java_25638_CredentialValidator_A03(String username) {
            this.username = username;
        }

        public String getUsername() {
            return this.username;
        }
    }

    public static class Validator implements javax.security.auth.CredentialValidator {

        @Override
        public String getCaller() throws IllegalArgumentException {
            return "Caller";
        }

        @Override
        public String getRequiredPrivilege() throws IllegalArgumentException {
            return "none";
        }

        @Override
        public String validate(String arg0) throws IllegalArgumentException, java.security.AccessDeniedException {
            if ("admin".equals(arg0)) {
                return "Success";
            } else {
                throw new AccessDeniedException("Access Denied");
            }
        }

        @Override
        public void reset() {
            // no-op
        }
    }

    public static void main(String[] args) {
        Credentials creds = new Credentials("admin");
        Validator validator = new Validator();
        String result = validator.validate(creds.getUsername());
        System.out.println(result);
    }
}