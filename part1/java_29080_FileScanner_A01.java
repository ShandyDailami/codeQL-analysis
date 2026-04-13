import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_29080_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        File startDirectory = new File(".");

        String[] unsafeExtensions = new String[]{"exe", "bat", "scr", "ps1", "ps2", "psc1", "vbs", "vbe", "vbe-x", "wsh", "wsf", "wsc", "jse", "jscript", "vbs", "vbe", "vbe-x", "wsh", "wsf", "wsc", "js", "jse", "jscript", "vbs", "vbe", "vbe-x", "wsh", "wsf", "wsc"};
        FilenameFilter filter = (dir, name) -> {
            for (String ext : unsafeExtensions) {
                if (name.endsWith(ext)) return false;
            }
            return true;
        };

        findFiles(startDirectory, filter);
    }

    private static void findFiles(File dir, FilenameFilter filter) throws IOException {
        File[] list = dir.listFiles(filter);
        if (list == null) return;

        for (File f : list) {
            if (f.isFile()) {
                if (f.getAbsolutePath().endsWith(f.getName())) {
                    System.out.println(f.getAbsolutePath());
                }
            } else if (f.isDirectory()) {
                findFiles(f, filter);
            }
        }
    }
}