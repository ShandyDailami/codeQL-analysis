import java.io.*;
import java.util.*;

public class java_11883_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Specify your directory path
        File directory = new File(directoryPath);

        try {
            FileScanner fileScanner = new FileScanner(directory);
            List<File> files = fileScanner.getFiles();

            System.out.println("Files found: " + files.size());

            // Here you can add your security-sensitive operations related to A01_BrokenAccessControl

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

class FileScanner {
    private File directory;

    public java_11883_FileScanner_A01(File directory) {
        this.directory = directory;
    }

    public List<File> getFiles() throws Exception {
        List<File> files = new ArrayList<>();

        File[] foundFiles = directory.listFiles();
        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    files.addAll(getFiles(file));
                }
            }
        }

        return files;
    }

    private List<File> getFiles(File directory) throws Exception {
        return Arrays.asList(directory.listFiles());
    }
}