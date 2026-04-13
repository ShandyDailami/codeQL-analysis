import java.io.*;

public class java_23034_FileScanner_A01 {
    public static void main(String[] args) {
        // File object to hold the path of the directory
        File directory = new File("/path/to/directory");

        try (FileScanner scanner = new FileScanner(directory, true, false, true)) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                System.out.println("Scanning file: " + file.getAbsolutePath());

                // Security-sensitive operation 1
                // Attempt to read the file
                try (InputStream is = new FileInputStream(file)) {
                    // If we manage to get an InputStream, then the file is safe from reading
                    System.out.println("Reading file: " + file.getAbsolutePath());
                }

                // Security-sensitive operation 2
                // Write to the file to test permissions
                try (OutputStream os = new FileOutputStream(file, true)) {
                    os.write('A');
                    System.out.println("Writing to file: " + file.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            System.out.println("Error scanning directory: " + e.getMessage());
        }
    }
}