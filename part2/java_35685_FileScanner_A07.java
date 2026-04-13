import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class java_35685_FileScanner_A07 {
    private final File[] roots;

    public java_35685_FileScanner_A07(File... roots) {
        this.roots = roots;
    }

    public File[] list(final String endWith) throws IOException {
        return list(new File(endWith));
    }

    public File[] list(final File directory) throws IOException {
        return directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                } else if (pathname.getName().toLowerCase().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        });
    }

    public File[] list(final String endWith, final File directory) throws IOException {
        return directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.toLowerCase().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        }, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                } else if (pathname.getName().toLowerCase().endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        });
    }
}