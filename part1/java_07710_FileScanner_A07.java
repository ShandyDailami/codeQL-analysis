import java.io.File;
import java.io.FilenameFilter;

public class java_07710_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory";
        String extension = "txt";

        File directory = new File(directoryPath);

        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files with extension " + extension + " found in " + directoryPath);
        }
    }
}