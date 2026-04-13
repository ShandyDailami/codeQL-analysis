import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36492_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory");
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Entering directory: " + directoryPath);

            String[] files = directory.list();

            for (String file : files) {
                if (file.endsWith(".txt")) {
                    System.out.println("Skipping file: " + file);
                    continue;
                }

                File fileObj = new File(directoryPath + "/" + file);
                long length = fileObj.length();
                System.out.println("File: " + file + ", Length: " + length + " bytes");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}