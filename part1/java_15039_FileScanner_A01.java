import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_15039_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory not found or not a valid directory");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Error listing files in directory");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File name: " + file.getName());
                System.out.println("Absolute path: " + file.getAbsolutePath());
            }
        }

        scanner.close();
    }
}