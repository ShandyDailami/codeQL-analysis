import java.io.File;
import java.io.FilenameFilter;

public class java_20029_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        File directory = new File(directoryPath);

        File[] hiddenFiles = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(".") && new File(dir, name).isFile();
            }
        });

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                System.out.println("Hidden file: " + file.getPath());
            }
        } else {
            System.out.println("No hidden files found in directory: " + directory.getPath());
        }
    }
}