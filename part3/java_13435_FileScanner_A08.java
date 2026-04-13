import java.io.File;
import java.util.Scanner;

public class java_13435_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();
        System.out.println("Enter the pattern for the file name:");
        String fileNamePattern = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] matchingFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension) && name.matches(fileNamePattern));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the provided criteria.");
        }
    }
}