import java.io.File;
import java.io.FilenameFilter;

public class java_07538_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            printFilesInDirectory(directory, new FileFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt"); // Accept only .txt files
                }
            });
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void printFilesInDirectory(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file, filter);
                }
            }
        }
    }
}