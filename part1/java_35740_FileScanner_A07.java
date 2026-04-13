import java.io.File;
import java.util.Scanner;

public class java_35740_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file pattern:");
        String filePattern = scanner.nextLine();

        File directory = new File(dirPath);

        File[] listOfFiles = directory.listFiles((dir, name) -> name.matches(filePattern));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getPath());
                    // Security sensitive operation here.
                    // For example, reading a file and checking if it contains a certain string.
                    // ...
                }
            }
        } else {
            System.out.println("Directory not found");
        }

        scanner.close();
    }
}