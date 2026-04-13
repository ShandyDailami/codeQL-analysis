import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class java_14311_FileScanner_A01 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        List<File> txtFiles = scanner.findFilesWithExtension(".txt");
        List<String> fileNames = txtFiles.stream()
                .map(file -> file.getName())
                .collect(Collectors.toList());
        System.out.println(fileNames);
    }

    private static class FileScanner {

        private List<File> findFilesWithExtension(String extension) {
            File directory = new File(".");
            FileFilter filter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(extension);
                }
            };
            List<File> files = new ArrayList<>();
            if (directory.isDirectory()) {
                directory.listFiles(filter);
            }
            return files;
        }
    }
}