import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_02714_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        try {
            scanFiles(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Invalid path or directory not found!");
        }
    }

    private static void scanFiles(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    scanFiles(f);
                }
            }
        } else {
            if (file.getName().endsWith(".txt")) {
                System.out.println("Found text file: " + file.getAbsolutePath());
            }
        }
    }
}