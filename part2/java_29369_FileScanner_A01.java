import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_29369_FileScanner_A01 implements FileFilter {
    private final Pattern fileNamePattern;

    public java_29369_FileScanner_A01(String fileNamePattern) {
        this.fileNamePattern = Pattern.compile(fileNamePattern);
    }

    @Override
    public boolean accept(File path) {
        return fileNamePattern.matcher(path.getName()).matches();
    }

    public static void main(String[] args) {
        String directoryPath = "path/to/directory";  // replace with your directory path
        File file = new File(directoryPath);

        if (file.exists() && file.isDirectory()) {
            JavaFileScanner scanner = new JavaFileScanner("%s.java");
            File[] foundFiles = file.listFiles(scanner);

            if (foundFiles != null) {
                for (File foundFile : foundFiles) {
                    System.out.println("Found file: " + foundFile.getPath());
                }
            } else {
                System.out.println("No .java files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory or file.");
        }
    }
}