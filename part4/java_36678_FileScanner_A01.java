import java.io.File;
import java.util.regex.Pattern;

public class java_36678_FileScanner_A01 {
    public static void main(String[] args) {
        String directory = "C:\\myDirectory";  // replace with your directory
        String pattern = ".*test.*";  // replace with your pattern

        Pattern regex = Pattern.compile(pattern);

        File root = new File(directory);
        listFiles(root, regex);
    }

    private static void listFiles(File dir, Pattern regex) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, regex);
                } else if (file.getName().matches(regex.pattern())) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}