import java.io.File;
import java.util.Scanner;

public class java_34390_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Searching for files in: " + directoryPath);

            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("Found file: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in directory: " + directoryPath);
            }
        } else {
            System.out.println(directoryPath + " is not a valid directory.");
        }

        scanner.close();
    }
}