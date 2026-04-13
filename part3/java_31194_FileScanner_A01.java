import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class java_31194_FileScanner_A01 {

    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        String extension = "java";

        FileScanner scanner = new FileScanner(directory, extension);

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }

    static class FileScanner {
        private final File[] files;
        private int current;

        public java_31194_FileScanner_A01(String directory, String extension) {
            FileFilter filter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(extension);
                }
            };
            this.files = directory.endsWith(File.separator) ?
                    pathname.listFiles(filter) :
                    pathname.listFiles(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return new File(dir, name).isFile() && name.endsWith(extension);
                        }
                    });
            Arrays.sort(this.files, String.CASE_INSENSITIVE_ORDER);
            this.current = 0;
        }

        public boolean hasNext() {
            return this.current < this.files.length;
        }

        public File next() {
            return this.files[this.current++];
        }
    }
}