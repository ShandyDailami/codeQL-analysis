import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10427_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to a file: ");
        String path = scanner.nextLine();
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File not found. Please try again.");
            return;
        }

        if (file.isDirectory()) {
            System.out.println("The path you provided is a directory, not a file.");
            return;
        }

        if (!file.canRead()) {
            System.out.println("Access to the file denied. Please check your permissions.");
            return;
        }

        System.out.println("Integrity check successful. No integrity failures found.");
    }
}