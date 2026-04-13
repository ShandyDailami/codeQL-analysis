import java.io.File;
import java.util.Scanner;

public class java_24304_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        System.out.println("Enter file extension (e.g., .txt):");
        String fileExtension = scanner.nextLine();

        File directory = new File(dirPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println("Found file: " + txtFile.getName());
            }
        } else {
            System.out.println("No files with extension " + fileExtension + " found in directory " + dirPath);
        }

        scanner.close();
    }
}