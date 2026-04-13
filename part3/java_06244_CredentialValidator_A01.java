public class java_06244_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_06244_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        if (username != null && username.equals("admin") && password != null && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

public class CredentialValidator {
    private UserCredential userCredential;

    public java_06244_CredentialValidator_A01(String username, String password) {
        userCredential = new UserCredential(username, password);
    }

    public boolean validate() {
        return userCredential.isValid();
    }
}