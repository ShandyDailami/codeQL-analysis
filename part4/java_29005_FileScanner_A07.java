import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_29005_FileScanner_A07 {

    public static void main(String[] args) {

        String directoryPath = "/path/to/directory"; // replace this with your directory path

        File dir = new File(directoryPath);

        File[] listOfFiles = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile();
            }
        });

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println(file.getName());
            }
        }
    }
}