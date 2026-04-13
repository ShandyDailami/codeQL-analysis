import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_00073_FileScanner_A08 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        // create a file
        File file = File.createTempFile("test", ".txt");
        file.deleteOnExit();
        
        // create a message digest
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        
        // write to the file
        Files.write(file.toPath(), new String("Hello, World!").getBytes(), StandardOpenOption.CREATE);
        
        // rehash the file
        digest.reset();
        digest.update(Files.readAllBytes(file.toPath()));
        
        // check the file's hash
        byte[] hashedBytes = digest.digest();
        String hashed = new String(hashedBytes);
        System.out.println(hashed);
        
        // remove the file
        Files.delete(file.toPath());
    }
}