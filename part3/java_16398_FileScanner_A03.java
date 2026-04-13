import java.io.File;
import java.io.FileFilter;

public class java_16398_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // Change this to your directory
        String filterStr = ".*\\.txt$";  // Change this to your filter, for example, .txt files

        File directory = new File(directoryPath);
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().matches(filterStr);
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getPath());
            }
        }
    }
}