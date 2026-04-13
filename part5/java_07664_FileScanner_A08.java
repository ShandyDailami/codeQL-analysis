import java.io.File;
import java.io.FilenameFilter;

public class java_07664_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            listFiles(directory, "");
        } else {
            System.out.println("Invalid directory");
        }
    }

    private static void listFiles(File directory, String indent) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, indent + "  ");  // indent for better readability
                } else {
                    System.out.println(indent + file.getName());
                }
            }
        }
    }
}