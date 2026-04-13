import java.io.File;
import java.util.Arrays;

public class java_41930_FileScanner_A08 {
    public static void main(String[] args) {
        // This directory path is for demonstration purposes.
        String directoryPath = "/path/to/your/directory";

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());

                        // Security-sensitive operations related to integrity failure.
                        // For example, checking the file's size and its last modified time.

                        // Only show the size if the file is not empty.
                        if (file.length() > 0) {
                            System.out.println("Size: " + file.length() + " bytes");
                            System.out.println("Last modified: " + file.lastModified());
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());

                        // Security-sensitive operations related to integrity failure.
                        // For example, calling listFiles for the directory.
                        File[] nestedFiles = file.listFiles();

                        if (nestedFiles != null) {
                            Arrays.stream(nestedFiles).forEach(nestedFile -> {
                                System.out.println("Nested file: " + nestedFile.getName());
                            });
                        }
                    }
                });
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}