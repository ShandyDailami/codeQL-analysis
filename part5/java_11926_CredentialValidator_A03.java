public class java_11926_CredentialValidator_A03 {
    private String password;

    public java_11926_CredentialValidator_A03(String password) {
        this.password = password;
    }

    public boolean validate(String inputPassword) {
        if (inputPassword == null) {
            return false;
        }

        if (inputPassword.length() != password.length()) {
            return false;
        }

        for (int i = 0; i < inputPassword.length(); i++) {
            if (inputPassword.charAt(i) != password.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}