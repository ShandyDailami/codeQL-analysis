import java.io.File;
import java.util.Scanner;

public class java_40298_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                }
            }
        } else {
            System.out.println("No files found with the specified extension.");
        }

        scanner.close();
    }
}