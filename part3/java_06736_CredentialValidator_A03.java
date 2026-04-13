public class java_06736_CredentialValidator_A03 {

    public static class CredentialValidator implements com.sun.security.auth.CredentialValidator {

        public boolean validate(InputStream credentials) throws IOException {
            Scanner s = new Scanner(credentials);
            String username = s.nextLine();
            String password = s.nextLine();
            return !username.isEmpty() && password.length() >= 8;
        }
    }

    public static void main(String[] args) throws Exception {
        javax.security.auth.login.LoginContext loginContext = new javax.security.auth.login.LoginContext("", new CredentialValidator());
        loginContext.login();
        System.out.println("Login successful");
    }
}