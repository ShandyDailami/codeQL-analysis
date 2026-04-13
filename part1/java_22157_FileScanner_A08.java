import java.io.File;
import java.util.Scanner;

public class java_22157_FileScanner_A08 {
    public static void main(String[] args) {
        // Define the directory to scan for files
        String directory = "/path/to/your/directory";
        File fileDirectory = new File(directory);

        // Create a FileScanner to scan files in the directory
        FileScanner scanner = new FileScanner(fileDirectory);

        // Loop over all files in the directory
        while (scanner.hasNext()) {
            File file = scanner.nextFile();

            // Check if the file is a directory
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
            }

            // Check if the file is a file (not a directory)
            else if (file.isFile()) {
                System.out.println("File: " + file.getAbsolutePath());
                
                // Check if the file is readable
                if (file.canRead()) {
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                       
                            // Check if the file has a valid line length
                            if (line.length() <= 500) {
                                System.out.println("Valid line length: " + line.length());
                            }

                            // Check if the file has a valid filename
                            if (file.getName().matches(".*\\.(txt|log)$")) {
                                System.out.println("Valid filename: " + file.getName());
                            }

                        }
                    }
                }
            }
        }
    }
}