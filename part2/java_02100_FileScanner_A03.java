import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02100_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File dir = new File(dirPath);
        if (dir.exists() && dir.isDirectory()) {
            FileScanner fileScanner = new FileScanner(dir, fileName);
            fileScanner.scan();

            if (fileScanner.getFoundFiles().length > 0) {
                System.out.println("File found in the directory: " + fileName);
            } else {
                System.out.println("File not found in the directory: " + fileName);
            }
        } else {
            System.out.println("Invalid directory: " + dirPath);
        }
    }
}