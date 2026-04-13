import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_05131_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");
        List<String> filePaths = new ArrayList<>();

        scanDirectory(file, "targetFile.txt", filePaths);

        for (String path : filePaths) {
            System.out.println(path);
        }
    }

    public static void scanDirectory(File directory, String targetFile, List<String> filePaths) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals(targetFile)) {
                        filePaths.add(file.getAbsolutePath());
                    } else if (file.isDirectory()) {
                        scanDirectory(file, targetFile, filePaths);
                    }
                }
            }
        }
    }
}