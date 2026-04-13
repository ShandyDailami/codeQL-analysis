import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_18266_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // replace with your directory path
        List<File> textFiles = getTextFilesInDirectory(directoryPath);
        for (File textFile : textFiles) {
            System.out.println(textFile.getName());
        }
    }

    public static List<File> getTextFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        return scanDirectory(directory, new ArrayList<>());
    }

    private static List<File> scanDirectory(File directory, List<File> files) {
        File[] directoryContents = directory.listFiles();
        if (directoryContents != null) {
            for (File content : directoryContents) {
                if (content.isDirectory()) {
                    // Recursive call for subdirectories
                    scanDirectory(content, files);
                } else if (content.getName().endsWith(".txt")) {
                    // Text file found
                    files.add(content);
                }
            }
        }
        return files;
    }
}