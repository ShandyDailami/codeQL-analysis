import java.io.*;

public class java_01431_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory
        String searchPattern = ".*"; // replace with your search pattern

        File directory = new File(directoryPath);
        File[] foundFiles = directory.listFiles((dir, name) -> name.matches(searchPattern));

        if (foundFiles != null) {
            for (File file : foundFiles) {
                try {
                    // Use File's read method to read the file contents
                    FileReader reader = new FileReader(file);
                    int character;
                    while ((character = reader.read()) != -1) {
                        // Perform security-sensitive operations
                        // ...
                    }
                    reader.close();
                } catch (IOException e) {
                    // Handle IOException if any
                    e.printStackTrace();
                }
            }
        }
    }
}