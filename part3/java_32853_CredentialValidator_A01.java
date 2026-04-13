public class java_32853_CredentialValidator_A01 {

    // Function to validate password
    public boolean validatePassword(String password) {
        if (password.length() < 10) {
            return false;
        }
        boolean upperCase = false, lowerCase = false, specialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) upperCase = true;
            if (Character.isLowerCase(ch)) lowerCase = true;
            if (!(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'))
                specialChar = true;
        }
        return (upperCase && lowerCase && specialChar);
    }

}