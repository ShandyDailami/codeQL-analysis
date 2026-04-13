import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class java_34381_FileScanner_A08 {
    private static final Pattern FILE_NAME_PATTERN = Pattern.compile("A08_IntegrityFailure.*");

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        scanDirectory(directoryPath);
    }

    public static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return FILE_NAME_PATTERN.matcher(pathname.getName()).matches();
            }
        });

        for (File file : files) {
            try {
                readFile(file);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getPath());
            }
        }
    }

    public static void readFile(File file) throws FileNotFoundException {
        System.out.println("Reading file: " + file.getPath());
        // read and process the file here
    }
}