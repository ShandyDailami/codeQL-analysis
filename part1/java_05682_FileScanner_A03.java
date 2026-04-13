import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_05682_FileScanner_A03 {
    public static void main(String[] args) {
        File dir = new File(".");
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".java");
            }
        });

        if (files != null) {
            for (File file : files) {
                if (isSafeToRead(file)) {
                    System.out.println("Reading file: " + file.getPath());
                }
            }
        }
    }

    private static boolean isSafeToRead(File file) {
        // This is a very basic example of how you might check if a file is safe to read.
        // In a real application, you would probably want to use a more complex approach.
        return file.canRead() && Pattern.matches(".*(import|package).*", file.getPath());
    }
}