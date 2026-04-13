import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_02939_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        if (!directory.canRead()) {
            System.out.println("Cannot read directory!");
            System.exit(1);
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory!");
            System.exit(1);
        }

        Arrays.stream(files)
                .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
                .forEach(file -> {
                    try {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File size: " + file.length() + " bytes");
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getName());
                    }
                });

        scanner.close();
    }
}