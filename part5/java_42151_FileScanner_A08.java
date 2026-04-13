import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class java_42151_FileScanner_A08 {

    public static void main(String[] args) {
        File dir = new File(".");
        String[] extensions = {".txt"};

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                for (String extension : extensions) {
                    if (pathname.getName().endsWith(extension)) {
                        return true;
                    }
                }
                return false;
            }
        };

        File[] listOfFiles = dir.listFiles(fileFilter);
        if (listOfFiles != null) {
            Arrays.stream(listOfFiles).forEach(file -> System.out.println(file.getName()));
        }
    }
}