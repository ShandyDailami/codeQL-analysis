// Code snippet:

public class java_07449_CredentialValidator_A03 {

    // Step 1: Define an array of users.
    private String[][] users = {
            {"user1", "password1"},
            {"user2", "password2"},
            {"user3", "password3"},
    };

    // Step 2: Implement the validate method.
    public boolean validate(String username, String password) {
        boolean isValid = false;

        // Step 3: Iterate over the users array.
        for (int i = 0; i < users.length; i++) {
            // Step 4: If the username and password match the user in the array, set isValid to true.
            if (users[i][0].equals(username) && users[i][1].equals(password)) {
                isValid = true;
                break;
            }
        }

        // Step 5: Return the isValid status.
        return isValid;
    }
}