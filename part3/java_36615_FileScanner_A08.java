import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_36615_FileScanner_A08 {

    public static void main(String[] args) throws IOException {
        FileSystems.DefaultFileAttributeView view =
                Files.getFileAttributeView(Paths.get("yourFilePath"), DefaultFileAttributeView.class);

        // Define the byte sequence to check
        byte[] target = "targetSequence".getBytes();

        // Read the file
        File file = new File("yourFilePath");
        byte[] bytes = Files.readAllBytes(file.toPath());

        // Check the file integrity
        if (checkIntegrity(bytes, target)) {
            System.out.println("The file is valid.");
        } else {
            System.out.println("The file is not valid.");
        }
    }

    private static boolean checkIntegrity(byte[] bytes, byte[] target) {
        if (bytes.length != target.length) {
            return false;
        }
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}