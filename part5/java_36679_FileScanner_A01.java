import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36679_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        try {
            scanFilesInDirectory(new File(dirPath));
        } catch (FileNotFoundException e) {
            System.err.println("Invalid path. Please try again.");
        }
    }

    public static void scanFilesInDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanFilesInDirectory(file);
                } else {
                    if (file.getName().endsWith(".txt")) {
                        System.out.println("Found file: " + file.getPath());
                    }
                }
            }
        }
    }
}