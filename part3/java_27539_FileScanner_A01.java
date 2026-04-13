import java.io.File;
import java.io.FilenameFilter;

public class java_27539_FileScanner_A01 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String extension = ".*txt";

        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with extension: " + extension);
        }
    }
}