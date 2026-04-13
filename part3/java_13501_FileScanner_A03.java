import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_13501_FileScanner_A03 {
    public static void main(String[] args) {
        // Get the directory from the command line arguments
        if (args.length == 0) {
            System.out.println("Please provide a directory as an argument");
            return;
        }

        String directoryPath = args[0];

        // Check if the directory exists
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // Scan all files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    readFile(file);
                }
            }
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}