import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_12492_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Replace with your directory
        countTxtFiles(directory, ".*\\.txt$");
    }

    private static void countTxtFiles(String directory, String fileFilter) {
        File root = new File(directory);
        countTxtFiles(root, fileFilter);
    }

    private static void countTxtFiles(File root, String fileFilter) {
        File[] files = root.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.matches(fileFilter, name);
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (Pattern.matches(fileFilter, file.getName())) {
                        System.out.println("Found .txt file: " + file.getAbsolutePath());
                        // You can add your security-sensitive operations here
                    }
                } else {
                    countTxtFiles(file, fileFilter);
                }
            }
        }
    }
}