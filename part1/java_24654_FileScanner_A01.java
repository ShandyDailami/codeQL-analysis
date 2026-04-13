import java.io.File;
import java.util.Scanner;

public class java_24654_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            fileSearch(directory, "");
        } else {
            System.out.println("Invalid directory or it doesn'
                             't exist.");
        }
    }

    private static void fileSearch(File directory, String directoryPath) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Security-sensitive operation here...
                    System.out.println(directoryPath + file.getName());
                } else if (file.isDirectory()) {
                    fileSearch(file, directoryPath + file.getName() + "/");
                }
            }
        }
    }
}