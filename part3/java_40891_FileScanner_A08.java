import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_40891_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                System.out.println(fileScanner.nextLine());
                            }
                        } catch (Exception e) {
                            System.out.println("Error reading file: " + file.getName());
                        }
                    }
                });
            } else {
                System.out.println("No files found in the directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}