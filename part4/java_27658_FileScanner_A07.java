import java.io.File;
import java.util.Scanner;

public class java_27658_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] matchingFiles = directory.listFiles((dir, name) -> name.endsWith(fileName));

        if (matchingFiles != null) {
            for (File file : matchingFiles) {
                System.out.println("File path: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the name " + fileName + " in the directory " + directoryPath);
        }

        scanner.close();
    }
}