import java.util.Base64;

public class java_01167_CredentialValidator_A01 {
    // A simple validation method that checks if a user's credentials match a hard-coded one
    public boolean validate(String user, String password) {
        String hardCodedUser = "admin";
        String hardCodedPassword = "password";
        
        // Convert the input and hard-coded passwords to byte arrays
        byte[] userBytes = user.getBytes();
        byte[] passwordBytes = password.getBytes();
        byte[] hardCodedPasswordBytes = hardCodedPassword.getBytes();
        
        // Check if the input user and password match the hard-coded ones
        if(Arrays.equals(userBytes, hardCodedUser.getBytes()) 
                && Arrays.equals(Base64.getDecoder().decode(hardCodedPasswordBytes), passwordBytes)) {
            return true;
        } else {
            return false;
        }
    }
}