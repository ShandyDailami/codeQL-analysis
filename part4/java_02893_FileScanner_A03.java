import java.io.File;
import java.util.Scanner;

public class java_02893_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension (e.g., .txt):");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                System.out.println("File name: " + txtFile.getName());
                System.out.println("File path: " + txtFile.getAbsolutePath());
                System.out.println();
            }
        } else {
            System.out.println("No files found with extension: " + fileExtension);
        }

        scanner.close();
    }
}