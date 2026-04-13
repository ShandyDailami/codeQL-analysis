public class java_07154_CredentialValidator_A03 {

    public static boolean validate(String username, String password) {
        // Check if the username is empty
        if (username == null || username.isEmpty()) {
            return false;
        }

        // Check if the password is empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Here we are assuming that the username and password match the following conditions:
        // 1. The username is 'admin' and the password is 'admin'
        // 2. The username is 'user' and the password is 'user'
        return (username.equals("admin") && password.equals("admin")) || 
               (username.equals("user") && password.equals("user"));
    }

    public static void main(String[] args) {
        // Testing the validation
        if (validate("admin", "admin")) {
            System.out.println("Validated as admin");
        } else {
            System.out.println("Not validated as admin");
        }

        if (validate("user", "user")) {
            System.out.println("Validated as user");
        } else {
            System.out.println("Not validated as user");
        }
    }
}