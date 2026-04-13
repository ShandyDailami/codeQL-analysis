import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_42125_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "path_to_directory"; // specify your directory here
        File dir = new File(directory);
        printFilesInDirectory(dir);
    }

    private static void printFilesInDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isFileSafeToRead(file)) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }

    private static boolean isFileSafeToRead(File file) {
        if (file.getName().endsWith(".txt")) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Add your own security logic here. For example, check if the line contains a password.
                    // If so, return false.
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }
}