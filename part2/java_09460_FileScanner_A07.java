import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class java_09460_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        ArrayList<String> fileNames = new ArrayList<>();

        // Scan directory
        scanDirectory(directory, fileNames);

        // Print file names
        for (String name : fileNames) {
            System.out.println(name);
        }
    }

    // Recursive method to scan a directory
    private static void scanDirectory(File directory, ArrayList<String> fileNames) {
        File[] files = directory.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                // Recursive call for directories
                scanDirectory(file, fileNames);
            } else if (file.getName().endsWith(".txt")) {
                // Security-sensitive operation related to A07_AuthFailure
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Perform some operation on the line (not shown here)
                    }
                    scanner.close();
                } catch (Exception e) {
                    System.out.println("Error reading file: " + file.getName());
                }
                fileNames.add(file.getName());
            }
        }
    }
}