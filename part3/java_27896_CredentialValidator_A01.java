import java.util.Base64;

public class java_27896_CredentialValidator_A01 {
    private String adminUserName;
    private String adminPassword;

    public java_27896_CredentialValidator_A01() {
        // These should be encrypted and stored in a secure location for the sake of demonstration
        this.adminUserName = "admin";
        this.adminPassword = "password";
    }

    public boolean validateCredentials(String user, String password) {
        // Decode the credentials to Base64 before comparing
        byte[] decodedUser = Base64.getDecoder().decode(user);
        byte[] decodedPassword = Base64.getDecoder().decode(password);

        String decodedUserString = new String(decodedUser);
        String decodedPasswordString = new String(decodedPassword);

        if (decodedUserString.equals(this.adminUserName) && decodedPasswordString.equals(this.adminPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        String user = "YWRtaW4="; // admin
        String password = "YWRtaW4="; // password

        if (validator.validateCredentials(user, password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}