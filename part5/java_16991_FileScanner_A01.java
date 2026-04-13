import java.io.File;
import java.util.Scanner;

public class java_16991_FileScanner_A01 {
    public static void main(String[] args) {
        String currentDirectory = new File(".").getAbsolutePath();
        scanDirectory(currentDirectory);
    }

    private static void scanDirectory(String directory) {
        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    // This is a file, not a directory
                    if (file.getName().endsWith(".java")) {
                        // This is a Java file
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            // Remove the comment for actual execution
                            // System.out.println("//" + line);
                            }
                        }
                    } else {
                        // This is not a Java file, skip it
                        System.out.println("Skipping non-Java file: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    // This is a directory, recursively scan it
                    scanDirectory(file.getAbsolutePath());
                }
            }
        }
    }
}