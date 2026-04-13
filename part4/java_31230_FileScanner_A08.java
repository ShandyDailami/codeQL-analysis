import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_31230_FileScanner_A08 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        List<String> fileNames = scanner.scan("C:\\path\\to\\directory");
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

}

class FileScanner {

    public List<String> scan(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }
        return fileNames;
    }
}