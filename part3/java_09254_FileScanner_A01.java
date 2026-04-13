import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_09254_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            scanDirectory(new File(directoryPath));
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }

    private static void scanDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    if (file.getName().endsWith(".java")) {
                        FileScanner fileScanner = new FileScanner(file);
                        fileScanner.scan();
                    }
                }
            }
        }
    }
}