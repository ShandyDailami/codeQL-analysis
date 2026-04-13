import java.io.File;
import java.util.Scanner;

public class java_23152_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    System.out.println("File found and can be read.");
                } else {
                    System.out.println("File found but cannot be read.");
                }
            } else {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}