import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_05690_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "C:\\Windows";  // example directory
        Pattern pattern = Pattern.compile(".*txt");  // example pattern

        File dir = new File(directoryPath);

        // using anonymous class to filter files
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !name.startsWith(".") && new File(dir, name).isFile();
            }
        });

        // if files are null, directory is empty
        if (files != null) {
            for (File file : files) {
                if (pattern.matcher(file).matches()) {
                    System.out.println(file.getName());
                }
            }
        }
    }
}