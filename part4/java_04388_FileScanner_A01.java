import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_04388_FileScanner_A01 {

    public List<String> findFiles(String directoryPath, final String extension) {
        List<String> fileNames = new ArrayList<>();
        File dir = new File(directoryPath);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        };
        File[] files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                fileNames.add(file.getPath());
            }
        }
        return fileNames;
    }
}