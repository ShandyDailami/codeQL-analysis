import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_12611_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isFileSafeToScan(file)) {
                        System.out.println("File: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }

    private static boolean isFileSafeToScan(File file) {
        // Assume the file is safe if it's a text file and does not contain any known injection techniques
        return file.isFile() && !file.getName().contains("__injection__");
    }
}