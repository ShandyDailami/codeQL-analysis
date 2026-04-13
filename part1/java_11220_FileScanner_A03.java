import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_11220_FileScanner_A03 {

    private static final String DIRECTORY_PATH = "path/to/directory";
    private static final String FILE_NAME = "file.txt";
    private static final String[] EXTENSIONS = {".txt", ".jpg", ".png"};

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        List<File> fileList = getFilesWithSpecificNameAndExtensions(directory, FILE_NAME, EXTENSIONS);
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static List<File> getFilesWithSpecificNameAndExtensions(File directory, String name, String[] extensions) {
        List<File> fileList = new ArrayList<>();
        if (directory.isDirectory()) {
            for (File file : directory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(File.separator + name);
                }
            })) {
                if (file.getName().equals(name)) {
                    String extension = '';
                    if (file.getPath().endsWith(extension)) {
                        fileList.add(file);
                    }
                }
            }
        }
        return fileList;
    }
}