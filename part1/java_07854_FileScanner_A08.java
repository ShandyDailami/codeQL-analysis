import java.io.File;
import java.util.Scanner;

public class java_07854_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] matchingFiles = directory.listFiles((dir, name) -> name.endsWith(fileName));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found in the directory.");
        }

        scanner.close();
    }
}