public class java_02771_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(String username, String password) {
        // Check complexity requirements
        if (password.matches(".*[^a-zA-Z].*") || password.matches(".*[^A-Z].*") || password.matches(".*[^0-9].*") || 
            password.matches(".*[^a-zA-Z0-9].*") || password<｜begin▁of▁sentence｜>.matches("^.{8,}$") == false) {
            return false;
        }

        // Password is valid
        return true;
    }

}