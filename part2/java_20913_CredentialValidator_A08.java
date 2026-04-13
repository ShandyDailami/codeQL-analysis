import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_20913_CredentialValidator_A08 {
    private String passwordToCheck;

    public java_20913_CredentialValidator_A08(String passwordToCheck) {
        this.passwordToCheck = passwordToCheck;
    }

    public boolean isPasswordCorrect(String passwordAttempt) throws CryptoException {
        if (passwordAttempt == null) {
            throw new CryptoException("null passwordAttempt");
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(passwordAttempt.getBytes("default"));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < thedigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & thedigest[i]));
            }
            passwordToCheck = hexString.toString();
            return passwordToCheck.equals(PasswordToCheck());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String PasswordToCheck() {
        // TODO Auto-generated method stub
        return null;
    }

    public class CryptoException extends Exception {
        public java_20913_CredentialValidator_A08(String arg) {
            // TODO Auto-generated constructor stub
            super(arg);
        }
    }
}