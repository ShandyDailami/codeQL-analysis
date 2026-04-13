import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class java_19836_FileScanner_A07 {
    private static final String SPECIFIC_EXTENSION = ".txt";
    private static final String ROOT_DIRECTORY = "C:/"; // replace with your directory

    public static void main(String[] args) {
        List<File> files = getFiles(new File(ROOT_DIRECTORY));
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    private static List<File> getFiles(File rootDirectory) {
        List<File> files = new ArrayList<>();
        for (File file : rootDirectory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(SPECIFIC_EXTENSION)) {
                files.add(file);
            } else if (file.isDirectory()) {
                files.addAll(getFiles(file));
            }
        }
        return files;
    }
}