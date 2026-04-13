import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_16223_FileScanner_A08 {
    private static String targetDirectory;
    private static String targetFileExtension;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter target directory: ");
        targetDirectory = scanner.nextLine();

        System.out.print("Enter target file extension: ");
        targetFileExtension = scanner.nextLine();

        scanFiles(new File(targetDirectory));
    }

    private static void scanFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanFiles(file);
                } else if (file.getName().endsWith(targetFileExtension)) {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            // Add your security-sensitive operation here
                            // For example, verify if a line is empty or not
                            if (line.isEmpty()) {
                                System.out.println("Empty line found in file: " + file.getPath());
                            }
                        }
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}