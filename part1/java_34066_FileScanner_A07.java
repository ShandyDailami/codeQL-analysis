import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class java_34066_FileScanner_A07 {
    private static final String DIRECTORY = "path_to_directory"; // replace with your directory path
    private static final String EXTENSION = "extension"; // replace with your extension

    public static void main(String[] args) {
        List<File> files = findFiles(new File(DIRECTORY), new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(EXTENSION) && new AuthFailureChecker().check(pathname);
            }
        });

        printFiles(files);
    }

    private static List<File> findFiles(File directory, FileFilter filter) {
        List<File> files = new ArrayList<File>();
        File[] listFiles = directory.listFiles(filter);

        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    files.addAll(findFiles(file, filter));
                }
            }
        }
        return files;
    }

    private static void printFiles(List<File> files) {
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}

class AuthFailureChecker {
    public boolean check(File file) {
        // Insert your security-sensitive operation here. For example, checking if a file has been modified after a certain time
        // You can use the `file.lastModified()` method to get the last modification time

        // For this example, return false if the file has not been modified after a certain time
        return file.lastModified() > System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 30;
    }
}