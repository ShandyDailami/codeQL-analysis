import java.io.File;
import java.util.regex.Pattern;

public class java_25005_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory";
        String filePattern = "regex_pattern_to_match_files";

        Pattern pattern = Pattern.compile(filePattern);
        File directory = new File(directoryPath);

        scanDirectory(directory, pattern);
    }

    private static void scanDirectory(File directory, Pattern pattern) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, pattern);
                } else if (file.isFile() && pattern.matcher(file).matches()) {
                    System.out.println("Matched file: " + file.getAbsolutePath());
                }
            }
        }
    }
}