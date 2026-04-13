import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_27846_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File dir = new File(".");
        String[] files = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        if (files != null) {
            for (String file : files) {
                File f = new File(dir, file);
                if (isVulnerable(f)) {
                    System.out.println("Vulnerable file: " + f);
                }
            }
        }
    }

    private static boolean isVulnerable(File f) throws IOException {
        // This is a simple security check for a file name injection
        // It's a creative way to demonstrate a security issue
        if (f.getName().contains("inject")) {
            System.out.println("File name contains 'inject', skipping...");
            return false;
        }
        if (f.length() > 1000) {
            System.out.println("Skipping file with length " + f.length());
            return false;
        }
        // Continue with other checks...
        return true;
    }
}