import java.io.*;

public class java_37213_FileScanner_A07 {
    private static final String DIRECTORY = "/path/to/directory";
    private static final String FILE_EXTENSION = ".*\\.txt";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        try (FileScanner fileScanner = new FileScanner()) {
            fileScanner.scanDirectory(directory, FILE_EXTENSION);
        } catch (IOException e) {
            System.err.println("An error occurred while scanning the directory: " + e.getMessage());
        }
    }

    public void scanDirectory(File directory, String fileExtension) throws IOException {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // perform security-sensitive operations related to A07_AuthFailure
                    // for example, checking if the file is empty or contains sensitive information
                    if (file.length() == 0) {
                        System.out.println("File " + file.getName() + " is empty.");
                    } else {
                        System.out.println("File " + file.getName() + " contains sensitive information.");
                   
                        // remove file
                        file.delete();
                    }
                } else if (file.isDirectory()) {
                    // recursive call to scan the directory
                    scanDirectory(file, fileExtension);
                }
            }
        }
    }
}