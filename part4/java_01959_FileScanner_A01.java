import java.io.File;
import java.io.IOException;

public class java_01959_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "C:/"; // replace with your directory path
        File directory = new File(directoryPath);

        // list all files and directories in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        }
    }
}