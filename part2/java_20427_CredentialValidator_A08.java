public class java_20427_CredentialValidator_A08 {

    public static boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!"A08_IntegrityFailure".contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("Aa1!123")); // Returns true
        System.out.println(isValid("Aa11!123")); // Returns false
        System.out.println(isValid("A1111!123")); // Returns false
        System.out.println(isValid("Aa111111!123")); // Returns true
    }
}