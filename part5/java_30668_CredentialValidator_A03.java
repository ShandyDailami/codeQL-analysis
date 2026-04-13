public class java_30668_CredentialValidator_A03 {

    public boolean validate(String username, String password) {
        // Step 1: Split the password into individual characters
        // Step 2: Reverse the order of the characters
        // Step 3: Join the characters back into a string
        // Step 4: Compare the result to the original password

        String reversedPassword = new StringBuilder(password).reverse().toString();

        if (reversedPassword.equals(username)) {
            return true;
        } else {
            return false;
        }
    }
}