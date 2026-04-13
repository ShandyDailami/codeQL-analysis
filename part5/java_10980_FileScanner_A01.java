import java.io.File;
import java.util.Scanner;

public class java_10980_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(0);
        }

        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory!");
            System.exit(0);
        }

        System.out.println("Files in the directory:");

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files found in the directory!");
            System.exit(0);
        }

        for (File file : files) {
            if (!file.isHidden()) {
                System.out.println(file.getName());
            }
        }

        scanner.close();
    }
}