import java.io.File;
import java.util.Scanner;

public class java_18265_FileScanner_A03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        // Get the directory object
        File dir = new File(dirPath);

        // Get all the files in the directory
        File[] files = dir.listFiles();

        // Check if files are present
        if (files != null) {
            for (File file : files) {
                // Check if the file is a regular file
                if (file.isFile()) {
                    // Check if the file name is "credentials.txt"
                    if (file.getName().equals("credentials.txt")) {
                        System.out.println("File found: " + file.getAbsolutePath());
                        // TODO: Use a security-sensitive operation to read the file
                        // For simplicity, this operation just prints the file content
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                System.out.println(fileScanner.nextLine());
                            }
                            fileScanner.close();
                        } catch (Exception e) {
                            System.out.println("Error reading file: " + e.getMessage());
                        }
                    }
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }

        scanner.close();
    }
}