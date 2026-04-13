import java.io.File;
import java.util.Scanner;

public class java_10939_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Enter file name to search:");
            String fileName = scanner.nextLine();
            File file = new File(directory, fileName);
            if (file.exists() && !file.isDirectory()) {
                System.out.println("File exists: " + file.getAbsolutePath());
            } else {
                System.out.println("File does not exist.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
        scanner.close();
    }
}