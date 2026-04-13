import java.io.File;
import java.util.Scanner;

public class java_21517_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.next();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.next();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files == null) {
            System.out.println("No files found with the extension: " + fileExtension);
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("Found file: " + file.getName());
            }
        }
    }
}