import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_19761_FileScanner_A03 {
    private static final Set<String> VALID_EXTENSIONS = new HashSet<>(Arrays.asList("java"));

    public static void main(String[] args) {
        String directoryPath = args.length > 0 ? args[0] : ".";

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("Cannot read directory");
            return;
        }

        File[] files = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() &&
                        !pathname.getName().startsWith(".") &&
                        VALID_EXTENSIONS.contains(pathname.getName().substring(pathname.getName().lastIndexOf(".") + 1));
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found");
        }
    }
}