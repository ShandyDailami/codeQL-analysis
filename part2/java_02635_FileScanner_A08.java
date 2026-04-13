import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_02635_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        List<String> fileNames = getFiles(new File(directoryPath));
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    private static List<String> getFiles(File directory) {
        List<String> fileNames = new ArrayList<>();
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });
        for (File file : files) {
            fileNames.add(file.getName());
        }
        return fileNames;
    }
}