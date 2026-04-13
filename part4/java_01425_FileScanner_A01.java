import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_01425_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory not found.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory.");
            return;
        }

        File[] hiddenFiles = directory.listFiles((dir, name) -> name.startsWith("."));

        if (hiddenFiles == null) {
            System.out.println("No hidden files found.");
            return;
        }

        for (File file : hiddenFiles) {
            if (file.getName().endsWith(".dat")) {
                try {
                    System.out.println("Reading file: " + file.getAbsolutePath());
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getAbsolutePath());
                }
            }
        }

        scanner.close();
    }
}