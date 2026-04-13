import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_11924_FileScanner_A03 {
    private File file;

    public java_11924_FileScanner_A03(File file) {
        this.file = file;
    }

    public void listTextFiles() {
        File[] textFiles = file.listFiles(new TextFileFilter());

        if (textFiles != null) {
            for (File textFile : textFiles) {
                System.out.println(textFile.getName());
            }
        }
    }

    private static final Pattern TEXT_FILE_EXTENSIONS = Pattern.compile(".*\\.txt$", Pattern.CASE_INSENSITIVE);

    private class TextFileFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            return TEXT_FILE_EXTENSIONS.matcher(name).matches();
        }
    }

    public static void main(String[] args) {
        File rootDirectory = new File("."); // Assuming current directory
        new TextFileScanner(rootDirectory).listTextFiles();
    }
}