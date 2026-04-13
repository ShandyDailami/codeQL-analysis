import java.io.File;
import java.util.Scanner;

public class java_29284_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String filePath = scanner.next();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("The file does not exist.");
            return;
        }

        if (file.isFile()) {
            if (file.canRead()) {
                System.out.println("The file is readable.");
            } else {
                System.out.println("The file is not readable.");
            }
        } else if (file.isDirectory()) {
            System.out.println("The file is a directory.");
            if (file.canRead()) {
                System.out.println("The directory is readable.");
            } else {
                System.out.println("The directory is not readable.");
            }
        } else {
            System.out.println("The file is not a file or directory.");
        }
    }
}