import java.security.InvalidParameterException;

public class java_23807_CredentialValidator_A01 {

    public boolean validateAccess(String userId, String password) {
        // For simplicity, let's assume we have a hardcoded list of valid users.
        String[] validUsers = {"user1", "user2", "user3"};

        // Check if userId is present in validUsers
        boolean isValidUser = false;
        for (String validUser : validUsers) {
            if (validUser.equals(userId)) {
                isValidUser = true;
                break;
            }
        }

        // If userId is not valid, throw an InvalidParameterException
        if (!isValidUser) {
            throw new InvalidParameterException("Invalid userId: " + userId);
        }

        // For simplicity, let's check if password is the same as userId.
        // In reality, you would have some mechanism to compare the password with a hash or salt.
        if (!password.equals(userId)) {
            throw new InvalidParameterException("Invalid password for userId: " + userId);
        }

        // If all checks pass, return true.
        return true;
    }
}