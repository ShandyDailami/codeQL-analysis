import java.io.File;
import java.util.Scanner;

public class java_11022_FileScanner_A01 {
    public static void main(String[] args) {
        // Create a File object for the directory we want to scan
        File directory = new File(".");

        // Scan the directory
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File dir = new File(path);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File name: " + file.getName());
                }
            }
        } else {
            System.out.println("Error: " + path + " does not exist.");
        }
    }
}