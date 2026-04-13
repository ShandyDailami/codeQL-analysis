import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_06897_FileScanner_A08 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String directoryPath = "/path/to/directory"; // Replace with your directory path

        File dir = new File(directoryPath);
        File[] dirContents = dir.listFiles();

        if (dirContents != null) {
            for (File file : dirContents) {
                if (file.isFile()) {
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    FileInputStream fis = new FileInputStream(file);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        md.update(buffer, 0, length);
                    }
                    byte[] digest = md.digest();
                    // Verify integrity with original file
                    File originalFile = new File(file.getPath().replaceFirst(directoryPath, ""));
                    if (Files.sameFile(Paths.get(file.getPath()), Paths.get(originalFile.getPath()))) {
                        System.out.println("File " + file.getName() + " is OK");
                    } else {
                        System.out.println("File " + file.getName() + " is corrupted");
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Directory " + file.getName() + " is OK");
                }
            }
        }
    }
}