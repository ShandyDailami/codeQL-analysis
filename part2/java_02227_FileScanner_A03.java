import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02227_FileScanner_A03 {

    public static void main(String[] args) {
        String currentDir = new File(".").getAbsolutePath();
        String securitySensitiveDir = currentDir + "/security-sensitive";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the name of a file in the security-sensitive directory:");
            String fileName = scanner.nextLine();
            String filePath = securitySensitiveDir + "/" + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                System.out.println("File exists: " + filePath);
            } else {
                System.out.println("File does not exist: " + filePath);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}