public class java_41122_CredentialValidator_A03 {
    public static boolean validate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        // Here we're just checking if the username and password are the same as the
        // ones provided in the constructor. In a real application, you would likely
        // use some kind of secure hash or encryption to store passwords.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("admin", "password"));  // should print true
        System.out.println(validate("wrong", "password"));  // should print false
        System.out.println(validate("admin", "wrong"));      // should print false
        System.out.println(validate("", "", ""));              // should print false
    }
}