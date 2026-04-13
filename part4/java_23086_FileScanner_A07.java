import java.io.File;
import java.io.FilenameFilter;
import java.security.Permission;
import java.security.SecurityPermission;

public class java_23086_FileScanner_A07 {

    private static class FileVisitorPermission extends SecurityPermission {
        private static final long serialVersionUID = 1;

        FileVisitorPermission(String name) {
            super(name);
        }
    }

    public static void main(String[] args) {
        String directoryPath = args[0];
        String fileName = args[1];

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!directory.canRead()) {
            System.out.println("You do not have read permissions for this directory!");
            return;
        }

        File[] files = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.equals(fileName);
            }
        });

        if (files == null || files.length == 0) {
            System.out.println("File does not exist!");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("Found file: " + file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println("Found directory: " + file.getAbsolutePath());
            }
        }
    }
}