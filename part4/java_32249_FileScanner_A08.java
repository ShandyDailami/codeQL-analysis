import java.io.File;
import java.io.FileFilter;

public class java_32249_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory";

        File directory = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isHidden() && pathname.isFile();
            }
        };

        File[] hiddenFiles = directory.listFiles(filter);

        if (hiddenFiles != null) {
            for (File file : hiddenFiles) {
                // Here you can add code to process each hidden file
                System.out.println("Hidden file: " + file.getName());
            }
        }
    }
}