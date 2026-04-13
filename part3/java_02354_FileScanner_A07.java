import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_02354_FileScanner_A07 {
    private final Pattern fileNamePattern;

    public java_02354_FileScanner_A07(String fileNamePattern) {
        this.fileNamePattern = Pattern.compile(fileNamePattern);
    }

    public void scan(String directoryPath) {
        File dir = new File(directoryPath);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory: " + dir.getAbsolutePath());
            return;
        }

        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return fileNamePattern.matcher(pathname.getName()).matches();
            }
        });

        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    System.out.println(file.getAbsolutePath());
                } else {
                    System.out.println("Unable to read file: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Unable to list files in directory: " + dir.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        new AuthFailureScanner("A07_AuthFailure.*").scan("/path/to/your/directory");
    }
}