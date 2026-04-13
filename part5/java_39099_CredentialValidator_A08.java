import java.util.Scanner;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.encodings.HexEncoding;
import org.bouncycastle.util.io.pem.PEMReader;

public class java_39099_CredentialValidator_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        // Hash the password using SHA256
        SHA256Digest digest = new SHA256Digest();
        digest.update(password.getBytes(), 0, password.getBytes().length);
        byte[] bytes = new byte[digest.getDigestSize()];
        digest.doFinal(bytes, 0);
        String hashedPassword = new HexEncoding().encode(bytes);

        // Compare the hashed password with the hard-coded one
        if (username.equals("admin") && hashedPassword.equals("5e884898da280471eab729032204d18b2962e039f")) {
            System.out.println("Welcome admin!");
        } else {
            System.out.println("Incorrect username or password!");
        }
    }
}