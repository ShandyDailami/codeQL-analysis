import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38049_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";  // replace with your directory
        File dir = new File(directory);

        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && isFileSafe(file)) {
                    printFileContents(file);
                }
            }
        }
    }

    private static boolean isFileSafe(File file) {
        // Check if the file is in a safe location.
        // This is a placeholder and may not be accurate.
        // For example, if the file contains sensitive information or if it is in a safe location.
        return true;
    }

    private static void printFileContents(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}