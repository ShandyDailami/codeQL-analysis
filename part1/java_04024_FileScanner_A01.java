import java.io.File;
import java.util.Arrays;

public class java_04024_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null && files.length > 0) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File path: " + file.getAbsolutePath());
                        System.out.println("---------------------");
                    }
                });
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("The provided path is not a valid directory.");
        }
    }
}