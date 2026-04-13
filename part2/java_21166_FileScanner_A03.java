import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21166_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        System.out.println("Enter file name:");
        String fileName = scanner.nextLine();

        File dir = new File(dirPath);

        File file = new File(dir, fileName);

        try {
            if (file.exists()) {
                System.out.println("File path: " + file.getAbsolutePath());
            } else {
                System.out.println("File not found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}