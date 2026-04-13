import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29527_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter the target file name:");
        String targetFileName = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] matchingFiles = directory.listFiles((dir, name) -> name.endsWith(targetFileName));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found in the directory.");
        }

        scanner.close();
    }
}