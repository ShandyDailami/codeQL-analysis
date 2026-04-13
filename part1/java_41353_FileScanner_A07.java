import java.io.File;
import java.io.IOException;

public class java_41353_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory
        countFilesAndDirectories(directoryPath);
    }

    private static void countFilesAndDirectories(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The provided path is not a directory");
            return;
        }

        int fileCount = 0;
        int directoryCount = 0;

        try {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileCount++;
                    } else if (file.isDirectory()) {
                        directoryCount++;
                        countFilesAndDirectories(file.getAbsolutePath());
                    }
                }
            }

            System.out.println("Number of files: " + fileCount);
            System.out.println("Number of directories: " + directoryCount);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the directory: " + e.getMessage());
        }
    }
}