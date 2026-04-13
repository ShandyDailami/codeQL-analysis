import java.io.File;
import java.io.FileFilter;

public class java_00262_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String fileExtension = ".txt"; // replace with your file extension

        File directory = new File(directoryPath);
        findFiles(directory, fileExtension);
    }

    private static void findFiles(File directory, String fileExtension) {
        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                // This filter will return true for all files.
                // In a real-world scenario, you would need to implement a secure file
                // access control mechanism, for example by checking the file's permissions.
                return true;
            }
        };

        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(fileExtension)) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    findFiles(file, fileExtension);
                }
            }
        }
    }
}