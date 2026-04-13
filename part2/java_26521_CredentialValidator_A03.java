public class java_26521_CredentialValidator_A03 implements CredentialValidator {

    private List<String> validUsernames = Arrays.asList("admin", "user1", "user2");
    private List<String> validPasswords = Arrays.asList("password", "password123", "123password");

    @Override
    public boolean validate(Credential c) throws InvalidCredentialException {
        if (validUsernames.contains(c.getUsername()) && validPasswords.contains(c.getPassword())) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username or password.");
        }
    }
}