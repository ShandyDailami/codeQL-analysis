import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class java_02958_FileScanner_A01 {
    private static final Pattern VALID_EXTENSIONS = Pattern.compile("^.+\\.(\\w+)$");
    private final File[] roots;

    public java_02958_FileScanner_A01(File... roots) {
        this.roots = roots != null ? roots : new File[0];
    }

    public void scan(final String extension, final String name, final FileFilter filter) {
        for (final File file : roots) {
            file(file, extension, name, filter);
        }
    }

    public void scan(final String extension, final FileFilter filter) {
        for (final File file : roots) {
            file(file, extension, filter);
        }
    }

    private void file(final File file, final String extension, final FileFilter filter) {
        final File[] files = file.listFiles(filter);
        if (files == null) {
            return;
        }
        for (final File f : files) {
            if (f.isDirectory()) {
                file(f, extension, filter);
            } else if (f.getName().toLowerCase().endsWith(extension.toLowerCase())) {
                // Do something with f
            }
        }
    }

    private void file(final File file, final String extension, final String name, final FileFilter filter) {
        if (file.isDirectory()) {
            file(file, extension, filter);
        } else if (VALID_EXTENSIONS.matcher(file.getName()).matches() && file.getName().endsWith(extension)) {
            // Do something with file
        }
    }
}