import java.io.File;
import java.util.Scanner;

public class java_30559_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String dir = scanner.next();
        System.out.println("Enter the file name:");
        String name = scanner.next();
        System.out.println("Enter the file extension:");
        String extension = scanner.next();

        File directory = new File(dir);
        File[] matchingFiles = directory.listFiles((dir1, name1) -> name1.endsWith(extension));

        if (matchingFiles != null && matchingFiles.length > 0) {
            System.out.println("File found: " + matchingFiles[0].getName());
        } else {
            System.out.println("No file found with the provided name and extension.");
        }

        scanner.close();
    }
}