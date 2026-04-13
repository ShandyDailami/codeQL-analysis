import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_35356_FileScanner_A03 implements FilenameFilter {

    private final Pattern acceptedFileExtensions;

    public java_35356_FileScanner_A03(String[] acceptedExtensions) {
        this.acceptedFileExtensions = Pattern.compile(".*\\." + Pattern.quote(String.join("|", acceptedExtensions)) + "$");
    }

    @Override
    public boolean accept(File dir, String name) {
        return acceptedFileExtensions.matcher(name).matches();
    }

    public static void main(String[] args) {
        String[] extensions = new String[]{"txt", "log", "properties", "xml"};
        FileScanner scanner = new SecureFileScanner(extensions);
        File directory = new File(".");
        File[] result = directory.listFiles(scanner);
        if (result != null) {
            Arrays.stream(result).forEach(file -> System.out.println(file.getName()));
        }
    }
}