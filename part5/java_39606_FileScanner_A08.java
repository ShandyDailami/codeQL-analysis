import java.io.*;

public class java_39606_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileExtension = ".*";

        File directory = new File(directoryPath);

        try (FileScanner fileScanner = new FileFinder(directory, fileExtension)) {
            while (fileScanner.hasNext()) {
                File file = fileScanner.nextFile();
                if (isFileSensitive(file)) {
                    System.out.println("File: " + file.getPath() + " has integrity failure.");
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static boolean isFileSensitive(File file) {
        // This method will be implemented by the developer.
        // It should return true if the file is likely to contain sensitive information.
        // For the purposes of this example, we'll just assume that a file with a '.txt' extension is sensitive.
        String name = file.getName();
        return name.endsWith(".txt");
    }
}