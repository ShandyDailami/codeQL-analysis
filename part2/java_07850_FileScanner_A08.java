import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class java_07850_FileScanner_A08 implements FileFilter {
    private Set<String> extensions;
    private Pattern fileNamePattern;

    public java_07850_FileScanner_A08(String[] extensions, String fileNamePattern) {
        this.extensions = new HashSet<>(Arrays.asList(extensions));
        this.fileNamePattern = Pattern.compile(fileNamePattern);
    }

    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }

        String name = pathname.getName();
        if (!fileNamePattern.matcher(name).matches()) {
            return false;
        }

        int lastDot = name.lastIndexOf('.');
        if (lastDot == -1) {
            return false;
        }

        String extension = name.substring(lastDot + 1);
        return this.extensions.contains(extension);
    }

    public static void main(String[] args) {
        String[] extensions = new String[]{"txt", "doc", "pdf"};
        String fileNamePattern = ".*[0-9].*";
        SecureFileScanner scanner = new SecureFileScanner(extensions, fileNamePattern);

        File file = new File(".");
        File[] files = file.listFiles(scanner);
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}