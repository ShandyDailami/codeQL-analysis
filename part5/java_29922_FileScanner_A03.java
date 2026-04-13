import java.io.File;
import java.util.Scanner;

public class java_29922_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        System.out.println("Enter file name to search:");
        String fileName = scanner.nextLine();

        File dir = new File(dirPath);
        File file = new File(dir, fileName);

        if (file.exists()) {
            System.out.println("File found: " + file.getAbsolutePath());
        } else {
            System.out.println("File not found in the specified directory.");
        }
    }
}