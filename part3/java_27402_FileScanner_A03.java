import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27402_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.setDirectory("C:\\path\\to\\directory"); // Set the directory
        scanner.setFilePattern("*.txt"); // Set the file pattern

        try {
            File file = scanner.getFirstFile();
            while (file != null) {
                System.out.println("Found file: " + file.getAbsolutePath());
                file = scanner.getNextFile();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + scanner.getDirectory());
            e.printStackTrace();
        }
    }
}

class FileScanner {
    private String directory;
    private String filePattern;

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setFilePattern(String filePattern) {
        this.filePattern = filePattern;
    }

    public File getFirstFile() throws FileNotFoundException {
        return getNextFile(directory);
    }

    public File getNextFile(String directory) throws FileNotFoundException {
        File filesDirectory = new File(directory);
        File[] matchingFiles = filesDirectory.listFiles((dir, name) -> name.matches(filePattern));

        if (matchingFiles == null || matchingFiles.length == 0) {
            throw new FileNotFoundException("No files found matching pattern: " + filePattern);
        }

        return matchingFiles[0];
    }
}