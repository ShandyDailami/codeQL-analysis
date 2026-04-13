import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_02643_FileScanner_A03 {
    private static final String DIRECTORY = "/path/to/directory"; // replace with your directory path
    private static final String EXTENSION = "extension"; // replace with your extension

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        List<File> fileList = new ArrayList<>();
        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(EXTENSION);
            }
        });

        if (files != null) {
            for (File file : files) {
                fileList.add(file);
            }
        }

        printFileNames(fileList);
    }

    private static void printFileNames(List<File> fileList) {
        for (File file : fileList) {
            System.out.println(file.getName());
        }
    }
}