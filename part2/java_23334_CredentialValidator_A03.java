public class java_23334_CredentialValidator_A03 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String RESERVED_WORDS = "password admin";

    public boolean validate(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        if (!password.matches(".*[" + SPECIAL_CHARACTERS + "].*")) {
            return false;
        }

        for (String word : RESERVED_WORDS.split(" ")) {
            if (password.contains(word)) {
                return false;
            }
        }

        return true;
    }
}