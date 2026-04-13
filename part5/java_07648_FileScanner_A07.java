import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_07648_FileScanner_A07 {
    private String directoryPath;

    public java_07648_FileScanner_A07(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public List<String> scan() {
        List<String> fileNames = new ArrayList<>();

        File rootDirectory = new File(directoryPath);
        File[] allFiles = rootDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                } else if (pathname.getName().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        });

        for (File file : allFiles) {
            fileNames.add(file.getName());
        }

        return fileNames;
    }

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner("/path/to/directory");
        List<String> fileNames = scanner.scan();

        for (String name : fileNames) {
            System.out.println(name);
        }
    }
}