public class java_27588_CredentialValidator_A03 {

    public static boolean validate(String username, String password) {
        // In a real system, you would check against a database here
        // This is a placeholder, you should replace this with your own logic
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String username = "admin";
        String password = "password";

        if (validate(username, password)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
}