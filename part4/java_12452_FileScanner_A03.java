import java.io.*;
import java.util.*;

public class java_12452_FileScanner_A03 {
    private static final String DIRECTORY = "C:\\Path\\To\\Directory";
    private static final String EXTENSION = ".*\\.txt$";

    public static void main(String[] args) {
        File dir = new File(DIRECTORY);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Error: The provided path is not a directory.");
            return;
        }

        try {
            FileScanner fileScanner = new FileScanner();
            fileScanner.scan(dir, EXTENSION);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static class FileScanner {
        public void scan(File directory, String extension) {
            List<File> files = new ArrayList<>();
            Queue<File> dirQueue = new LinkedList<>();

            dirQueue.add(directory);

            while (!dirQueue.isEmpty()) {
                File currentDir = dirQueue.poll();
                File[] dirContent = currentDir.listFiles();

                if (dirContent != null) {
                    for (File file : dirContent) {
                        if (file.isFile() && file.getName().endsWith(extension)) {
                            files.add(file);
                        } else if (file.isDirectory()) {
                            dirQueue.add(file);
                        }
                    }
                }
            }

            printFiles(files);
        }

        private void printFiles(List<File> files) {
            for (File file : files) {
                System.out.println("File: " + file.getAbsolutePath());
            }
        }
    }
}