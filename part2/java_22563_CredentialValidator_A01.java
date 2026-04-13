public class java_22563_CredentialValidator_A01 implements CredentialValidator {
    private List<User> userList;

    public java_22563_CredentialValidator_A01() {
        userList = new ArrayList<>();
        // populate userList with existing users
    }

    @Override
    public boolean validate(String username, String password) {
        // Assume each user is stored as a User object with username and password fields
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // user is validated
            }
        }
        return false; // user is not validated
    }
}