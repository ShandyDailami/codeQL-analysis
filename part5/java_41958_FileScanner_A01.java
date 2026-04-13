import java.io.File;
import java.util.Scanner;

public class java_41958_FileScanner_A01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file extension: ");
        String extension = scanner.next();

        File directory = new File(".");
        File[] filesList = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (filesList == null) {
            System.out.println("No files found with the given extension!");
            return;
        }

        for (File file : filesList) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        scanner.close();
    }
}