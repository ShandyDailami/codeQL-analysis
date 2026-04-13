import java.io.File;
import java.io.FilenameFilter;

public class java_35574_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path

        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt"); // accepts only .txt files
            }
        });

        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}