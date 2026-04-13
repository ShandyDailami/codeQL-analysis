import java.io.File;
import java.util.Scanner;

public class java_12147_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file name:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.equals(fileName));

        if (files != null) {
            for (File file : files) {
                System.out.println("File path: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("File not found in directory.");
        }

        scanner.close();
    }
}