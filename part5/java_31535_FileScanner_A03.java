import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_31535_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter file extension (e.g., '.txt'):");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files with extension " + fileExtension + " found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}