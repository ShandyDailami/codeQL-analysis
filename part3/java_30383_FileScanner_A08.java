import java.io.File;
import java.io.FilenameFilter;

public class java_30383_FileScanner_A08 {
    private static final String EXTENSION = ".txt"; // example extension

    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFilesWithExtension(directory, EXTENSION);
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }

    private static void listFilesWithExtension(File directory, String extension) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        });

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listFilesWithExtension(file, extension);
            }
        }
    }
}