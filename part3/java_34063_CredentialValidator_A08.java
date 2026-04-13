public class java_34063_CredentialValidator_A08 {

    public boolean validate(String password) {
        if (password == null) {
            return false;
        }

        boolean lengthOk = password.length() >= 8;
        boolean digitOk = password.matches(".*[0-9].*");
        boolean uppercaseOk = password.matches(".*[A-Z].*");
        boolean lowercaseOk = password.matches(".*[a-z].*");
        boolean specialOk = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        return lengthOk && digitOk && uppercaseOk && lowercaseOk && specialOk;
    }
}