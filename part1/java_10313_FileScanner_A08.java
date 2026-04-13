import java.io.File;
import java.util.Scanner;

public class java_10313_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Create a Scanner to read input files
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the directory path:");
            String dirPath = scanner.nextLine();

            // Create a File object for the directory
            File dir = new File(dirPath);

            // Get all files in the directory
            File[] files = dir.listFiles();

            // Check if files are null
            if(files == null) {
                System.out.println("No files in the directory");
                return;
            }

            // Iterate over all files
            for(File file : files) {
                if(file.isFile()) {
                    // Get the file name
                    String fileName = file.getName();

                    // Check if the file name is not empty
                    if(!fileName.isEmpty()) {
                        // Get the file extension
                        String extension = fileName.substring(fileName.lastIndexOf("."));

                        // Check if the file name ends with a security-sensitive operation
                        if(extension.equals(".exe")) {
                            System.out.println("Integrity failure detected in file: " + fileName);
                        }
                    }
                }
            }

            // Close the scanner
            scanner.close();

        } catch(Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}