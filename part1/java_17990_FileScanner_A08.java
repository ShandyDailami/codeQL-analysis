import java.io.File;
import java.security.SecureRandom;

public class java_17990_FileScanner_A08 {

    // Secure random instance for generating file names
    private static final SecureRandom rand = new SecureRandom();

    // Main method
    public static void main(String[] args) {
        int numberOfFiles = 5; // Amount of files to create
        String directoryPath = "/Users/username/Documents/"; // Directory where to create files

        try {
            File dir = new File(directoryPath);
            if (!dir.exists()) {
                dir.mkdirs(); // Create directory if it doesn't exist
            }

            for (int i = 0; i < numberOfFiles; i++) {
                String fileName = "file" + (i + 1) + ".txt";
                File file = new File(dir, fileName);
                file.createNewFile(); // Create a new file

                // Write a random string to the file
                String content = "This is file " + (i + 1) + ".txt";
                java.io.FileWriter writer = new java.io.FileWriter(file);
                writer.write(content);
                writer.close();
            }

            // Scan the directory
            FileScanner scanner = new FileScanner(dir, true);

            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                System.out.println("Found file: " + file.getAbsolutePath());
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}