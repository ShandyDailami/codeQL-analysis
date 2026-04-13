public class java_42038_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public boolean validate(String id, String password) {
        if (id == null || password == null) {
            return false;
        }

        if (id.length() == 0 || password.length() == 0) {
            return false;
        }

        if (!(id.matches("^[0-9]+$") && password.matches("^[0-9]+$"))) {
            return false;
        }

        int pin = Integer.parseInt(password);
        return pin >= 1000 && pin <= 9999;
    }
}