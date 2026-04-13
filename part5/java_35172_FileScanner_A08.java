import java.io.File;
import java.util.Scanner;

public class java_35172_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.next();
        System.out.print("Enter the file name: ");
        String fileName = scanner.next();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        if (file.exists()) {
            System.out.println("File path: " + file.getAbsolutePath());
        } else {
            System.out.println("File not found in the directory.");
        }
    }
}