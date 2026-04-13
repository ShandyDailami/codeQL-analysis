import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class java_27843_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Replace with your directory path
        String extension = ".txt";  // Replace with the file extension you want to filter

        File dir = new File(directoryPath);

        File[] listOfFiles = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        });

        Arrays.stream(listOfFiles).forEach(file -> System.out.println(file.getName()));
    }
}