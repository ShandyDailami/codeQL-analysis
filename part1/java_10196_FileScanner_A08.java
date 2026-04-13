import java.io.File;
import java.util.Scanner;

public class java_10196_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                System.out.println("File: " + file.getName());
                                System.out.println("Content: " + fileScanner.nextLine());
                           
                            }
                            fileScanner.close();
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }

        scanner.close();
    }
}