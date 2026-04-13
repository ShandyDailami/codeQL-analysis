import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16424_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File dir = new File(dirPath);
        File[] files = dir.listFiles((dir1, name) -> name.equals(fileName));

        if (files != null && files.length > 0) {
            System.out.println("File found: " + files[0].getAbsolutePath());
        } else {
            System.out.println("File not found.");
        }
    }
}