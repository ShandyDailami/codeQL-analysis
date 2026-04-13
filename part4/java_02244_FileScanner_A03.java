import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02244_FileScanner_A03 {

    public static void main(String[] args) {
        // Get the directory path from command line arguments
        if (args.length != 1) {
            System.out.println("Usage: FileScanner <directory>");
            return;
        }

        File directory = new File(args[0]);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Error: " + args[0] + " is not a valid directory");
            return;
        }

        // Scan the directory for files
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Error: Unable to list files in " + args[0]);
            return;
        }

        // Output the contents of each file
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("Contents of " + file.getAbsolutePath());
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Error: Unable to read " + file.getAbsolutePath());
                }
            }
        }
    }
}