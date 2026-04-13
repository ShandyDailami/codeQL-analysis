public class java_00890_CredentialValidator_A01 {

    public static final String ERROR_MESSAGE = "Error: credentials are required";

    public boolean validate(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println(ERROR_MESSAGE);
            return false;
        }
        if (password == null || password.trim().isEmpty()) {
            System.out.println(ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}