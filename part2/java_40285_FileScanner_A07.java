import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class java_40285_FileScanner_A07 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.setPattern(Pattern.compile(".*\\.txt$", Pattern.CASE_INSENSITIVE));
        scanner.setDirectory(new File("."));
        scanner.scan();
    }

    private static class FileScanner {
        private File directory;
        private Pattern pattern;

        public void setPattern(Pattern pattern) {
            this.pattern = pattern;
        }

        public void setDirectory(File directory) {
            this.directory = directory;
        }

        public void scan() {
            String[] files = directory.list();
            if (files != null) {
                Arrays.sort(files);
                for (String file : files) {
                    File fileObject = new File(directory, file);
                    if (fileObject.isFile() && pattern.matcher(file).matches()) {
                        System.out.println(fileObject.getPath());
                    }
                }
            }
        }
    }
}