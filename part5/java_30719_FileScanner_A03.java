import java.io.File;
import java.util.Scanner;

public class java_30719_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.next();
        System.out.print("Enter the file extension: ");
        String extension = scanner.next();

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files with the extension " + extension + " found in " + directoryPath);
        }

        scanner.close();
    }
}