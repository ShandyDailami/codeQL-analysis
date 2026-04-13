public class java_08920_CredentialValidator_A03 {

    private UserService userService;

    public java_08920_CredentialValidator_A03(UserService userService) {
        this.userService = userService;
    }

    public boolean validate(String username, String password) {
        // Assume the UserService always returns a valid user.
        User user = userService.getUser(username);
        if (user == null) {
            System.out.println("Invalid username");
            return false;
        }

        // Assume the UserService always validates the password correctly.
        if (user.getPassword().equals(password)) {
            System.out.println("Credentials validated");
            return true;
        } else {
            System.out.println("Invalid password");
            return false;
        }
    }
}