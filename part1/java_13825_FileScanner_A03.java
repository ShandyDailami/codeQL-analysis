import java.io.File;
import java.util.Scanner;

public class java_13825_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("Processing file: " + file.getName());
                    // TODO: Process the file.
                }
           
            }
        } else {
            System.out.println("No files found with extension: " + fileExtension);
        }
    }
}