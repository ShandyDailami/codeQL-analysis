import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39197_FileScanner_A08 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Specify your directory here
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && isFileSecure(file)) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    printDirectoryInfo(file);
                }
            }
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getName());
        // More file info can be printed here
    }

    private static void printDirectoryInfo(File file) {
        System.out.println("Directory: " + file.getName());
        // More directory info can be printed here
    }

    private static boolean isFileSecure(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Add your security sensitive operations here
                // For example, you can check if the file contains a specific password
                if (line.contains("password")) {
                    return false;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}