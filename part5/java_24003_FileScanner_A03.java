import java.io.File;
import java.util.Scanner;

public class java_24003_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name: ");
        String fileName = scanner.nextLine();

        File file = new File(directoryPath, fileName);

        if (file.exists()) {
            System.out.println("File found: " + file.getAbsolutePath());
        } else {
            System.out.println("File not found in the specified directory or subdirectories.");
        }
    }
}