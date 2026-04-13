import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13634_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File("."); // Use current directory
        String searchFileExtension = ".txt";

        System.out.println("Searching for files with extension: " + searchFileExtension + " in directory: " + directory.getAbsolutePath());

        File[] foundFiles = directory.listFiles((dir, name) -> name.endsWith(searchFileExtension));

        if (foundFiles != null) {
            for (File file : foundFiles) {
                try {
                    System.out.println("File content: " + readFileContent(file));
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No files found in directory: " + directory.getAbsolutePath());
        }
    }

    private static String readFileContent(File file) throws FileNotFoundException {
        return new Scanner(file).useDelimiter("\\Z").next();
    }
}