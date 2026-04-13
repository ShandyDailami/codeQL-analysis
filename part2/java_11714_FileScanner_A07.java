import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_11714_FileScanner_A07 {

    private static final Pattern VALID_EXTENSIONS = Pattern.compile("^.+\\.(txt|java)$");

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory/"; // replace with your directory path
        File directory = new File(directoryPath);

        if (directory.exists()) {
            findFiles(directory);
        } else {
            System.out.println("Directory does not exist!");
        }
    }

    private static void findFiles(File directory) {
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return VALID_EXTENSIONS.matcher(name).matches();
            }
        });

        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    findFiles(file);
                }
            });
        }
    }
}