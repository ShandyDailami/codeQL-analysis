import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_29633_FileScanner_A01 {
    private static final Pattern VALID_FILE_EXTENSIONS = Pattern.compile("^.+\\.(txt|doc|pdf|xlsx|exe)$");

    public static void main(String[] args) {
        String directory = "C:\\path\\to\\directory"; // your directory here
        String[] textFiles = getTextFilesInDirectory(new File(directory));
        Arrays.stream(textFiles).forEach(System.out::println);
    }

    private static String[] getTextFilesInDirectory(File directory) {
        return directory.list(new TextFileFilter());
    }

    private static class TextFileFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            File file = new File(dir, name);
            return file.isFile() && VALID_FILE_EXTENSIONS.matcher(file.getName()).matches();
        }
    }
}