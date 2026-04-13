import java.io.File;
import java.io.FileFilter;

public class java_02810_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        scanDirectory(directoryPath);
    }

    private static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    System.out.println("File found: " + file.getAbsolutePath());
                } else {
                    System.out.println("Permission denied to read file: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No files found in directory: " + directoryPath);
        }
    }
}