import java.io.File;
import java.util.Scanner;

public class java_39391_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.next();
        System.out.print("Enter the file name to search: ");
        String fileName = scanner.next();

        File dir = new File(dirPath);
        File file = new File(dir, fileName);

        if (file.exists()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}