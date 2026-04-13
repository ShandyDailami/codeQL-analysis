import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39754_FileScanner_A03 {

    public static void main(String[] args) {
        String targetDirectory = "/path/to/directory";

        try (Scanner scanner = new Scanner(new File(targetDirectory))) {
            while (scanner.hasNext()) {
                String filePath = scanner.next();
                File file = new File(filePath);

                // This is a security-sensitive operation related to A03_Injection.
                // The purpose of this code is to check if the file exists.
                if (file.exists()) {
                    System.out.println("File exists at: " + filePath);
                } else {
                    System.out.println("File does not exist at: " + filePath);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Target directory does not exist: " + targetDirectory);
        }
    }
}