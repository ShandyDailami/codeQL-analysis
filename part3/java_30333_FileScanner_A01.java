import java.io.File;
import java.io.FilenameFilter;

public class java_30333_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt"); // this filters out all files that do not end with .txt
            }
        };

        File[] txtFiles = directory.listFiles(filter);

        if(txtFiles != null) {
            for (File file : txtFiles) {
                // Here you can write code to process the file
                // For example, print its name
                System.out.println(file.getName());
            }
        }
    }
}