public class java_20345_CredentialValidator_A01 implements CredentialValidator {

    private String username;
    private String password;

    public java_20345_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate(CredentialContext context) throws CredentialValidationException {
        // This is a very simple way to check if the username and password are correct. 
        // In a real scenario, you would likely want to use a more secure method of checking credentials, 
        // possibly involving hashing and salting the password and then comparing hashes.

        if (context.getUsername().equals(username) && context.getPassword().equals(password)) {
            return true;
        } else {
            throw new CredentialValidationException("Invalid username or password");
        }
    }
}