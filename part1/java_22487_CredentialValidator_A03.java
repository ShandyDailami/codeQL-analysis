public class java_22487_CredentialValidator_A03 {

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Split password into words
        String[] words = password.split(" ");

        // Check for any word in the list
        for (String word : words) {
            if ("password".equals(word) || "admin".equals(word)) {
                System.out.println("Invalid password detected. Password is likely a security sensitive operation related to A03_Injection.");
                return false;
            }
        }

        System.out.println("Valid password, proceed with authentication.");
        return true;
    }
}