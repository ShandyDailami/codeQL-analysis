import java.io.*;
import java.security.*;

public class java_10627_CredentialValidator_A01 {

    // Stored hash of password
    private String storedHash;

    public java_10627_CredentialValidator_A01() {
        try {
            FileReader reader = new FileReader("password.hash");
            BufferedReader bufferedReader = new BufferedReader(reader);
            this.storedHash = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validateCredentials(String enteredPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(enteredPassword.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            String enteredHash = sb.toString();
            return enteredHash.equals(this.storedHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
       .return false;
        }
    }
}