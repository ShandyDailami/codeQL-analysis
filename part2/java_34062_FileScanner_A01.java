import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class java_34062_FileScanner_A01 {
    private final String directoryPath;

    public java_34062_FileScanner_A01(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public List<String> scanFiles() {
        List<String> fileNames = new ArrayList<>();
        File dir = new File(directoryPath);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        fileNames.addAll(fileScan(dir, filter));

        return fileNames;
    }

    private List<String> fileScan(File directory, FileFilter filter) {
        List<String> fileNames = new ArrayList<>();
        File[] listOfFiles = directory.listFiles(filter);

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    fileNames.add(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    fileNames.addAll(fileScan(file, filter));
                }
            }
        }

        return fileNames;
    }
}