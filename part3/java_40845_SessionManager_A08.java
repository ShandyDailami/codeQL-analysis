import java.security.*;

public class java_40845_SessionManager_A08 {
    private static final String PSEUDO_RANDOM_STRING = "PseudoRandomString";

    public static void main(String[] args) {
        // We will use SHA256 for hashing the random string
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // We will use a pseudo random string as a salt
        String salt = PSEUDO_RANDOM_STRING;

        // We will generate a new hash and compare it with the salt
        byte[] hash = md.digest(salt.getBytes());

        // We will compare the hashes
        if (new String(hash).equals(md.digest(PSEUDO_RANDOM_STRING.getBytes()))) {
            System.out.println("IntegrityFailure has been successfully achieved!");
        } else {
            System.out.println("IntegrityFailure has failed!");
        }
    }
}