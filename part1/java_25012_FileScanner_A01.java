import java.io.File;
import java.util.Scanner;

public class java_25012_FileScanner_A01 {
    private static final String ROOT_DIR = "src";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory:");
        String dir = scanner.nextLine();
        printFilesInDirectory(new File(dir));
        scanner.close();
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file);
                } else {
                    printFileContent(file);
                }
            }
        }
    }

    private static void printFileContent(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while reading file: " + file.getAbsolutePath());
        }
    }
}