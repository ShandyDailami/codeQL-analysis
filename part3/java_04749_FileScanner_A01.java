import java.io.File;
import java.util.Scanner;

public class java_04749_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File(".");
        scanDirectory(file, "A01_BrokenAccessControl");
    }

    private static void scanDirectory(File directory, String searchString) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, searchString);
                } else if (file.isFile() && containsString(file, searchString)) {
                    System.out.println("File: " + file.getAbsolutePath() + " contains: " + searchString);
                }
            }
        }
    }

    private static boolean containsString(File file, String searchString) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getAbsolutePath());
        }
        return false;
    }
}