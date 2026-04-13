public class java_33707_CredentialValidator_A01 {

    public static void main(String[] args) {
        Credential credential = new Credential("admin", "password");
        System.out.println(validateCredential(credential));
    }

    public static boolean validateCredential(Credential credential) {
        if (credential.getUsername().equals("admin") && credential.getPassword().equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

class Credential {
    private String username;
    private String password;

    public java_33707_CredentialValidator_A01(String username, String password) {
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