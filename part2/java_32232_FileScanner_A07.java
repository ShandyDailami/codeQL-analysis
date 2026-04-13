import java.io.File;
import java.util.Scanner;

public class java_32232_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        System.out.println("Enter the extension of the files you want to scan:");
        String extension = scanner.nextLine();

        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File path: " + file.getAbsolutePath());
                }
            }
        }

        scanner.close();
    }
}