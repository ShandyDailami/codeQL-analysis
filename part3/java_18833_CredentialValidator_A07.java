public class java_18833_CredentialValidator_A07 {

    public static boolean validate(String enteredCredential) {
        // hardcoded string
        String hardcodedCredential = "admin";

        // if entered credential and hardcoded credential are the same, return true
        if (enteredCredential.equals(hardcodedCredential)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // test validate method
        System.out.println(validate("admin"));  // should print true
        System.out.println(validate("wrongCredential"));  // should print false
    }
}